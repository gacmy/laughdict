package com.gac.laughdict.presenter;

import android.content.Context;

import com.gac.laughdict.base.SuperPresenter;
import com.gac.laughdict.model.bean.ImageBean;
import com.gac.laughdict.model.bean.ImageList;
import com.gac.laughdict.model.net.HttpAsyncTask;
import com.gac.laughdict.model.net.utils.GsonUtil;
import com.gac.laughdict.model.net.utils.ParamsUtils;
import com.gac.laughdict.presenter.contract.ImageContract;
import com.gac.laughdict.utils.StringUtils;

import java.util.List;

/**
 * Created by gacmy on 2017/8/7.
 */

public class ImagePresenter extends SuperPresenter implements ImageContract.Presenter{
    ImageContract.View mView;
    Context context;
    private int mPage  =  1;
    public ImagePresenter(ImageContract.View view,Context context){
        mView = StringUtils.checkNotNull(view);
        mView.setPresenter(this);
        this.context = context;
        requestData();
    }

    private  void requestData(){
        HttpAsyncTask task = new HttpAsyncTask(context);
        task.setShowDialog(false).setMethod(HttpAsyncTask.METHOD_GET).setPostCompleteListener(new HttpAsyncTask.PostFormCompleteListener() {
            @Override
            public void onSuccess(String res) {
               ImageList imagelist =  GsonUtil.CommonJson(res, ImageList.class);

                List<ImageBean> list = null;
                if(imagelist !=  null){
                    list = imagelist.getData();
                }
                if(mPage == 1){
                    mView.showContent(list);
                }else{
                    mView.showMoreContent(list);
                }
                if((list == null || list.size() == 0 )&& mPage != 1){
                    mPage --;
                }

            }

            @Override
            public void onError(String msg) {
                mView.showError(msg);
            }
        }).setURL("http://japi.juhe.cn/joke/img/text.from").build().
                setMapParams(ParamsUtils.getLaughParams("pagesize","10","page",mPage+"")).execute();

    }
    @Override
    public void onRefresh() {
        mPage =  1;
        requestData();
    }

    @Override
    public void getContent() {

    }

    @Override
    public void onLoadMore() {
        mPage++;
        requestData();
    }
}
