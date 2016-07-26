package com.dyx.adlp.plugin.view.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import com.dyx.adlp.plugin.view.BaseActivity;

/**
 * project name：Android-Dynamic-Loading-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/26 上午11:12
 * alter person：dayongxin
 * alter time：16/7/26 上午11:12
 * alter remark：
 */
public class TestAct extends BaseActivity {
    public static final String CLASS_NAME = "com.dyx.adlp.plugin.view.ui.TestAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = new Button(mProxyActivity);
        button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        button.setBackgroundColor(Color.YELLOW);
        button.setText("这是测试页面");
        setContentView(button);
    }

}
