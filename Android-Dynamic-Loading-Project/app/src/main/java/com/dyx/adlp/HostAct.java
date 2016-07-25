package com.dyx.adlp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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
public class HostAct extends Activity {
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
        Intent intent = new Intent(HostAct.this, ProxyAct.class);
        //TODO apk文件地址
        intent.putExtra(ProxyAct.INTENT_PROXY_APK, "");
        startActivity(intent);
    }
}
