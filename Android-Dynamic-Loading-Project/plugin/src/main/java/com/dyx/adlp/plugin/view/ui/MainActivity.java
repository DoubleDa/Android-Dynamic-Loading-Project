package com.dyx.adlp.plugin.view.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dyx.adlp.plugin.R;
import com.dyx.adlp.plugin.view.BaseActivity;
import com.dyx.adlp.plugin.view.adapter.MainAdapter;
import com.dyx.adlp.plugin.widget.DividerItemDecoration;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.rv_menu)
    RecyclerView rvMenu;
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 纯代码实现
         */
        //initView(savedInstanceState);

        /**
         * 使用资源文件实现
         */
        mProxyActivity.setContentView(R.layout.act_main_layout);
        ButterKnife.bind(mProxyActivity);

        rvMenu.setLayoutManager(new LinearLayoutManager(mProxyActivity));
        rvMenu.addItemDecoration(new DividerItemDecoration(mProxyActivity, DividerItemDecoration.VERTICAL_LIST));
        rvMenu.setHasFixedSize(true);

        mMainAdapter = new MainAdapter(mProxyActivity, getDatas());
        rvMenu.setAdapter(mMainAdapter);

        mMainAdapter.setmOnRvItemClickListener(new MainAdapter.OnRvItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                switch (pos) {
                    case 0:
                        startActivityByProxy(TestAct.CLASS_NAME);
                        break;
                    case 1:
                        break;
                }
            }
        });
    }

    private List<String> getDatas() {
        return Arrays.asList(mProxyActivity.getResources().getStringArray(R.array.menu));
    }

//    private void initView(Bundle savedInstanceState) {
//        //mProxyActivity.setContentView(generateContentView(mProxyActivity));
//    }


//    private View generateContentView(final Context context) {
//        LinearLayout layout = new LinearLayout(context);
//        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT));
//        layout.setBackgroundColor(Color.parseColor("#F79AB5"));
//        Button button = new Button(context);
//        button.setText("button");
//        layout.addView(button, ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "you clicked button",
//                        Toast.LENGTH_SHORT).show();
//                startActivityByProxy("com.dyx.adlp.plugin.view.ui.TestAct");
//            }
//        });
//        return layout;
//    }
}
