package com.gac.laughdict.ui.holder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gac.demo.refresh.adapter.BaseViewHolder;
import com.gac.laughdict.R;
import com.gac.laughdict.model.bean.TextBean;

/**
 * Created by gacmy on 2017/8/7.
 */

public class TextLaughHolder extends BaseViewHolder<TextBean> {
    TextView tv_content;
    TextView tv_update;
    public TextLaughHolder(ViewGroup parent) {
        super(parent, R.layout.item_text_laugh);
        tv_content = $(R.id.tv_content);
        tv_update = $(R.id.tv_update);
    }

    @Override
    public void setData(TextBean data) {
        if(!TextUtils.isEmpty(data.getContent())){
            tv_content.setText(data.getContent());
        }
        if(!TextUtils.isEmpty(data.getUpdatetime())){
            tv_update.setText("更新时间: "+data.getUpdatetime());
        }
    }
}
