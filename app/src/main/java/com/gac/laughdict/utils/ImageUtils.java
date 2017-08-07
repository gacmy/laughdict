package com.gac.laughdict.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by gacmy on 2017/5/5.
 */

public class ImageUtils {
    //宽度全屏 等比放缩图片
    public static void  adjustBounds(ImageView iv, Context context){
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int screenWidth = dm.widthPixels;
        ViewGroup.LayoutParams lp = iv.getLayoutParams();
        lp.width = screenWidth;
        iv.setAdjustViewBounds(true);
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        iv.setLayoutParams(lp);
        iv.setMaxWidth(screenWidth);
        iv.setMaxHeight(dm.heightPixels);
    }
    private static File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(new Date());
        String imageFileName = "JPEG_" + timeStamp + ".jpg";
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        if (!storageDir.exists()) {
            if (!storageDir.mkdir()) {
                Log.e("TAG", "Throwing Errors....");
                throw new IOException();
            }
        }

        File image = new File(storageDir, imageFileName);

        // Save a file: path for use with ACTION_VIEW intents
       // mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }
//    public static final int REQUEST_TAKE_PHOTO = 1;
//    public static String takePhoto(Activity context, int requestId){
//        if (!PermissionsUtils.checkCameraPermission(context)) return null;
//        if (!PermissionsUtils.checkWriteStoragePermission(context)) return null;
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        // Ensure that there's a camera activity to handle the intent
//        File file = null;
//        if (takePictureIntent.resolveActivity(context.getPackageManager()) != null) {
//            // Create the File where the photo should go
//
//            try {
//                file = createImageFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Uri photoFile;
//            if (Build.VERSION.SDK_INT >=24) {
//                String authority = context.getApplicationInfo().packageName + ".provider";
//                photoFile = FileProvider.getUriForFile(context.getApplicationContext(), authority, file);
//            } else {
//                photoFile = Uri.fromFile(file);
//            }
//
//            // Continue only if the File was successfully created
//            if (photoFile != null) {
//                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoFile);
//            }
//        }
//
//
//            context.startActivityForResult(takePictureIntent, requestId);
//         return file.getAbsolutePath();
//
//    }
}
