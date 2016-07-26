package com.dyx.adlp.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;

import java.io.File;
import java.util.List;

/**
 * project name：Android-Dynamic-Loading-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/26 下午3:07
 * alter person：dayongxin
 * alter time：16/7/26 下午3:07
 * alter remark：
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAllPermission();
    }

    private void getAllPermission() {
        Acp.getInstance(this).request(new AcpOptions.Builder().setPermissions(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_PHONE_STATE, android.Manifest.permission.SEND_SMS).build(), new AcpListener() {
            @Override
            public void onGranted() {
                writeSd();
                getImie();
            }

            @Override
            public void onDenied(List<String> permissions) {
                showToast(permissions.toString() + "权限拒绝");
            }
        });
    }


    private File getCacheDir(String msg, Context context) {
        File result;
        if (isSdExist()) {
            File cacheDir = context.getExternalCacheDir();
            if (cacheDir == null) {
                result = new File(Environment.getExternalStorageDirectory(),
                        "Android/data/" + context.getPackageName() + "/cache/" + msg);
            } else {
                result = new File(cacheDir, msg);
            }
        } else {
            result = new File(context.getCacheDir(), msg);
        }

        if (result.exists() || result.mkdir()) {
            return result;
        } else {
            return null;
        }
    }

    private boolean isSdExist() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void getImie() {
        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (tm != null) {
            showToast("读imei成功：" + tm.getDeviceId());
        }
    }

    private void writeSd() {
        File myFile = getCacheDir("dyx", this);
        if (myFile != null) {
            showToast("写SD成功：" + myFile.getAbsolutePath());
        }
    }
}
