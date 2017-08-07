package com.gac.laughdict.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.gac.demo.refresh.adapter.BaseViewHolder;
import com.gac.demo.refresh.adapter.RecyclerArrayAdapter;
import com.gac.laughdict.ui.holder.TextLaughHolder;

/**
 * Created by gacmy on 2017/8/7.
 */

public class TextLaughAdapter extends RecyclerArrayAdapter {
    public TextLaughAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new TextLaughHolder(parent);
    }


}
