package com.gac.laughdict.ui.holder;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gac.demo.refresh.adapter.BaseViewHolder;
import com.gac.laughdict.R;
import com.gac.laughdict.model.bean.ImageBean;
import com.gac.laughdict.model.bean.TextBean;
import com.gac.laughdict.utils.ImageUtils;
import com.gac.laughdict.widget.imageloader.ImageLoader;

/**
 * Created by gacmy on 2017/8/7.
 */

public class ImageLaughHolder extends BaseViewHolder<ImageBean> {
    TextView tv_content;
    TextView tv_update;
    ImageView iv_image;
    public ImageLaughHolder(ViewGroup parent) {
        super(parent, R.layout.item_image_laugh);
        tv_content = $(R.id.tv_content);
        tv_update = $(R.id.tv_update);
        iv_image = $(R.id.iv_image);
    }

    @Override
    public void setData(ImageBean data) {
        if(!TextUtils.isEmpty(data.getContent())){
            tv_content.setText(data.getContent());
        }
        if(!TextUtils.isEmpty(data.getUpdatetime())){
            tv_update.setText("更新时间: "+data.getUpdatetime());
        }
        ImageUtils.adjustBounds(iv_image,getContext());
        if(!TextUtils.isEmpty(data.getUrl())){
            ImageLoader.loadImage(getContext(),data.getUrl(),iv_image);
        }
    }
}
