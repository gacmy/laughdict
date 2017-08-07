package com.gac.laughdict.widget.imageloader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by gacmy on 2017/8/7.
 */

public class ImageLoader {
    public static void loadImage(Context context,String url,ImageView iv){
        if(url.endsWith("gif")){
          loadImageGif(context,url,iv);
        }else{
            loadImageIV(context,url,iv);
        }
    }
    public static void  loadImageGif(Context context, String url, ImageView iv){
        Glide.with(context).asGif().load(url).into(iv);
    }
    public static void  loadImageIV(Context context, String url, ImageView iv){
        Glide.with(context).load(url).into(iv);
    }
}
