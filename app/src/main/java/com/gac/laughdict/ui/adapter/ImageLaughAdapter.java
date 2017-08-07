package com.gac.laughdict.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.gac.demo.refresh.adapter.BaseViewHolder;
import com.gac.demo.refresh.adapter.RecyclerArrayAdapter;
import com.gac.laughdict.ui.holder.ImageLaughHolder;
import com.gac.laughdict.ui.holder.TextLaughHolder;

/**
 * Created by gacmy on 2017/8/7.
 */

public class ImageLaughAdapter extends RecyclerArrayAdapter {
    public ImageLaughAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageLaughHolder(parent);
    }


}
