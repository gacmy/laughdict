package com.gac.laughdict.model.net.update;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import android.widget.TextView;


import com.gac.laughdict.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NotificationTool {

    private Context mContext;
    private final int NOTIFICATION_ID = 0x1111;
    public NotificationTool(Context context){
        this.mContext = context;
    }

    private NotificationCompat.Builder builder;
    private RemoteViews remoteViews;
    private Notification notification;
    public void sendCustomNotification(){
        builder = new NotificationCompat.Builder(mContext);
        builder.setSmallIcon(R.mipmap.ic_launcher);
//        if(isDarkNotification()){
//            remoteViews = new RemoteViews(mContext.getPackageName(),
//                    R.layout.dark_notification_layout);
//        }else{
//            remoteViews = new RemoteViews(mContext.getPackageName(),
//                    R.layout.white_notification_layout);
//        }
        remoteViews = new RemoteViews(mContext.getPackageName(),
                R.layout.dark_notification_layout);
        builder.setContent(remoteViews);
        notification = builder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL;
//        Intent intent = new Intent();
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
//                11,intent,PendingIntent.FLAG_CANCEL_CURRENT);
//        builder.setContentIntent(pendingIntent);
//        remoteViews.setOnClickPendingIntent(R.id.notification_layout,pendingIntent);
        ((NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE))
                .notify(NOTIFICATION_ID, notification);


    }
    public static boolean isDownLoading = false;
    public void notifyPer(int per){
        if(remoteViews != null && builder != null){
            remoteViews.setTextViewText(R.id.notification_text,"下载中\t\t" + per + "%");
            remoteViews.setProgressBar(R.id.notification_bar, 100, per, false);
            remoteViews.setViewVisibility(R.id.notification_reset, View.GONE);
            remoteViews.setViewVisibility(R.id.notification_bar, View.VISIBLE);
            ((NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE))
                    .notify(NOTIFICATION_ID, notification);
            isDownLoading = true;
        }else{
            isDownLoading = false;
        }
    }

    public void notifyFail(){
        isDownLoading = false;
        if(remoteViews != null){
            remoteViews.setViewVisibility(R.id.notification_bar, View.GONE);
            remoteViews.setViewVisibility(R.id.notification_reset, View.VISIBLE);
            remoteViews.setTextViewText(R.id.notification_text, "下载失败，点击");
            Intent intent = new Intent("com.gendii.foodfluency.action.update.reset");
            PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext,
                    11,intent, PendingIntent.FLAG_CANCEL_CURRENT);
            builder.setContentIntent(pendingIntent);
            remoteViews.setOnClickPendingIntent(R.id.notification_layout, pendingIntent);
            ((NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE))
                    .notify(NOTIFICATION_ID, notification);
        }
    }
    public void notifySuccess(){
        isDownLoading = false;
        if(remoteViews != null){
            remoteViews.setViewVisibility(R.id.notification_bar, View.GONE);
            remoteViews.setViewVisibility(R.id.notification_reset, View.GONE);
            remoteViews.setTextViewText(R.id.notification_text, "下载完成，点击安装");
            File file = new File(Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + "/hltapk" + "/" + "hlt.apk");
            Uri uri = Uri.fromFile(file);
            Intent installIntent = new Intent(Intent.ACTION_VIEW);
            installIntent.setDataAndType(uri, "application/vnd.android.package-archive");
            PendingIntent pendingIntent = PendingIntent.getActivity(mContext,
                    11, installIntent, PendingIntent.FLAG_CANCEL_CURRENT);
            builder.setContentIntent(pendingIntent);
            builder.build().flags = Notification.FLAG_AUTO_CANCEL;
            remoteViews.setOnClickPendingIntent(R.id.notification_layout, pendingIntent);
            ((NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE))
                    .notify(NOTIFICATION_ID, notification);
        }
    }


    private boolean isDarkNotification(){
        return !isColorSimilar(Color.BLACK,getNotificationColor(mContext));
    }

    private static final double COLOR_THRESHOLD = 180.0;
    private boolean isColorSimilar(int baseColor, int color) {
        int simpleBaseColor = baseColor | 0xff000000;
        int simpleColor = color | 0xff000000;
        int baseRed = Color.red(simpleBaseColor) - Color.red(simpleColor);
        int baseGreen = Color.green(simpleBaseColor) - Color.green(simpleColor);
        int baseBlue = Color.blue(simpleBaseColor) - Color.blue(simpleColor);
        double value = Math.sqrt(baseRed * baseRed + baseGreen * baseGreen + baseBlue * baseBlue);
        if(value < COLOR_THRESHOLD){
            return true;
        }
        return false;
    }

    private int getNotificationColor(Context context) {
        if(context instanceof AppCompatActivity){
            return getNotificationColorCompat(context);
        }else{
            return getNotificationColorInternal(context);
        }
    }

    private int getNotificationColorCompat(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        Notification notification = builder.build();
        int layoutId = notification.contentView.getLayoutId();
        ViewGroup notificationRoot = (ViewGroup) LayoutInflater.
                from(context).inflate(layoutId,null);
        TextView title = (TextView)notificationRoot.findViewById(android.R.id.title);
        if(title == null){
            //厂商更改了id，想办法从notificationRoot中找到title对应的textview
            //先拿到所有的textviews
            final List<TextView> textViews = new ArrayList<>();
            iteratorView(notificationRoot, new Filter() {
                @Override
                public void filter(View view) {
                    if(view instanceof TextView){
                        textViews.add((TextView)view);
                    }
                }
            });
            //可以认为字号最大的就是title
            float minTextSize = Integer.MIN_VALUE;
            int index = 0;
            for (int i= 0,j = textViews.size();i<j;i++){
                float currentSize = textViews.get(i).getTextSize();
                if(currentSize > minTextSize){
                    minTextSize = currentSize;
                    index = i;
                }
            }
            return textViews.get(index).getCurrentTextColor();

        }else{
            return title.getCurrentTextColor();
        }

    }

    private String DUMMY_TITLE = "DUMMY_TITLE";
    private int titleColor;
    private int getNotificationColorInternal(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle(DUMMY_TITLE);
        Notification notification = builder.build();
        ViewGroup notificationRoot = (ViewGroup)notification.
                contentView.apply(context,new FrameLayout(context));
        TextView title = (TextView)notificationRoot.findViewById(android.R.id.title);
        if(title == null){//厂商改了id
            iteratorView(notificationRoot, new Filter() {
                @Override
                public void filter(View view) {
                    if(view instanceof TextView){
                        TextView textView = (TextView)view;
                        if(DUMMY_TITLE.equals(textView.getText().toString())){
                            titleColor = textView.getCurrentTextColor();
                        }
                    }
                }
            });
            return titleColor;
        }else{
            return title.getCurrentTextColor();
        }
    }

    private void iteratorView(View view, Filter filter){
        if(view == null || filter == null){
            return;
        }
        filter.filter(view);
        if(view instanceof ViewGroup){
            ViewGroup continer = (ViewGroup)view;
            for (int i = 0,j = continer.getChildCount();i<j;i++){
                View child = continer.getChildAt(i);
                iteratorView(child,filter);
            }
        }
    }

    private interface Filter{
        void filter(View view);
    }



}
