package com.dyx.adlp.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.dyx.adlp.R;
import com.dyx.adlp.view.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * project name：Android-Dynamic-Loading-Project
 * class describe：宿主Activity
 * create person：dayongxin
 * create time：16/7/25 下午11:46
 * alter person：dayongxin
 * alter time：16/7/25 下午11:46
 * alter remark：
 */
public class HostAct extends BaseActivity {
    @Bind(R.id.but_start_proxy)
    Button butStartProxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_host_layout);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.but_start_proxy)
    public void onClick() {
        toProxyAct();
    }

    private void toProxyAct() {
        Intent intent = new Intent(HostAct.this, ProxyActivity.class);
        intent.putExtra(ProxyActivity.EXTRA_DEX_PATH, "/mnt/sdcard/dynamicLoadHost/plugin.apk");
        startActivity(intent);
    }
}
