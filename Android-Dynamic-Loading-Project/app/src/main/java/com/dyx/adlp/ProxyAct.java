package com.dyx.adlp;

import android.app.Activity;
import android.os.Bundle;

/**
 * project name：Android-Dynamic-Loading-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/25 下午11:52
 * alter person：dayongxin
 * alter time：16/7/25 下午11:52
 * alter remark：
 */
public class ProxyAct extends Activity {
    /**
     * http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2014/1013/1759.html
     */
    public static final String INTENT_PROXY_APK = "intent_proxy_apk";
    /**
     * 下载的apk包 存放目录
     */
    private String downloadApkDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_proxy_layout);
        downloadApkDir = getIntent().getStringExtra(INTENT_PROXY_APK);
    }
}
