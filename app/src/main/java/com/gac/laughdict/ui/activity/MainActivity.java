package com.gac.laughdict.ui.activity;


import android.os.Bundle;


import com.gac.laughdict.R;
import com.gac.laughdict.base.BaseActivity;
import com.gac.laughdict.model.net.HttpAsyncTask;
import com.gac.laughdict.ui.fragment.FirstFragment;
import com.gac.laughdict.ui.fragment.ImageFragment;
import com.gac.laughdict.ui.fragment.MyFragment;
import com.gac.laughdict.ui.fragment.TextFragment;
import com.gac.laughdict.widget.bottombar.MainNavigateTabBar;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by gacmy on 2017/8/3.
 */

public class MainActivity extends BaseActivity {
    @BindView(R.id.maintab) MainNavigateTabBar mainTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       // testRequest();
        initMainTab(savedInstanceState);

    }

    private void  initMainTab(Bundle savedInstanceState){
        mainTab.onRestoreInstanceState(savedInstanceState);
        mainTab.addTab(FirstFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.ic_home, R.mipmap.ic_home, "首页"));
        mainTab.addTab(TextFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.ic_text, R.mipmap.ic_text, "笑话"));
        mainTab.addTab(ImageFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.ic_text, R.mipmap.ic_text, "趣图"));
        mainTab.addTab(MyFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.ic_us, R.mipmap.ic_us, "我的"));

    }




    private void  testRequest(){
        HttpAsyncTask task = new HttpAsyncTask(this);
        Map<String,String> params = new HashMap<>();
        params.put("key","4486e7f3ad2fb806622807a66bc0f492");
        params.put("size","10");
        params.put("page","1");
        task.setShowDialog(false).setMethod(HttpAsyncTask.METHOD_GET).setPostCompleteListener(new HttpAsyncTask.PostFormCompleteListener() {
            @Override
            public void onSuccess(String res) {

            }

            @Override
            public void onError(String msg) {

            }
        }).setURL("http://japi.juhe.cn/joke/content/text.from").build().
                setMapParams(params).execute();
    }
}
