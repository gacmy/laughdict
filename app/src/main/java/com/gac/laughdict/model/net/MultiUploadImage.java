package com.gac.laughdict.model.net;

import android.content.Context;
import android.util.Log;



import java.io.File;
import java.util.List;


/**
 * Created by gacmy on 2017/4/24.
 */

public class MultiUploadImage {
//    List<String> mUrls;
//    ImageBean[] mRes;
//    CompleteListener mListener;
//    String baseUrl;
//    String mType;//1是缩略图 2是原图上传
//    List<ImageBean> mBeans;
//    Context mContext;
//    int[] list_complete;//0 未上传 1 上传成功 2 上传失败
//    public MultiUploadImage(List<String> files, String url, Context context, CompleteListener listener, List<ImageBean> beans){
//        mUrls = files;
//        mRes = new ImageBean[mUrls.size()];
//        list_complete = new int[mUrls.size()];
//        for(int i = 0; i < mUrls.size(); i++){
//            list_complete[i] = 0;
//        }
//        baseUrl = url;
//        mListener = listener;
//        mBeans = beans;
//        mContext = context;
//        if(SystemUtils.isWifiConnect(context)){
//            mType = "2";
//        }else{
//            mType = "1";
//        }
//    }
//    int length = 0;
//    public void start(){
//        length = 0;
//        if(mUrls.size() == 0){
//            mListener.complete(null);
//        }
//        for(int i = 0; i < mUrls.size(); i++){
//           // int index = i;
//
//            if(mUrls.get(i).contains("http:")){
//                length++;
//                list_complete[i] = 1;
//                mRes[i] = mBeans.get(i);
//            }else{
//
//                File file = new File(mUrls.get(i));
//
//
//                L.d("luban","yuantulength:"+file.length());
//                if(file.length() > 1024*1024*2){
//                    ImageCompress compress = new ImageCompress(mContext);
//                    compress.setComperssListener(new ImageCompress.CompressListener() {
//                        @Override
//                        public void onComplete(String file, int index) {
//                            L.d("luban","compressLength:"+file);
//                            uploadImage(file,index);
//                        }
//
//                        @Override
//                        public void onError(int index, String content) {
//                            L.d("luban","compressError:"+content);
//                            list_complete[index] = 2;
//                            if(list_complete.length == 1){
//                                mListener.complete(null);
//                            }
//                        }
//
//                        @Override
//                        public void onStart(int index) {
//                            L.d("luban","onStart:"+index);
//                        }
//                    });
//                    compress.execute(i,file );
//
//                }else{
//                  uploadImage(mUrls.get(i),i);
//                }
//
//
//            }
//
//
//        }
//
//        //全部是网络图片的情况
//        if(length == mUrls.size()){
//            mListener.complete(mRes);
//        }
//    }
//
//    private void uploadImage(String path, final int index){
//        new ImageUploadTask(new ImageUploadTask.PostFormCompleteListener(){
//
//            @Override
//            public void onSuccess(String res, String fileurl) {
//                Log.d("MultiUploadImage","index:"+index+" res:"+res+" fileUrl:"+fileurl);
//                if(TextUtil.isEmpty(res)){
//                    list_complete[index] = 2;
//                    mListener.onError("第"+index+"张图片上传失败");
//                    if(list_complete.length == 1){
//                        mListener.complete(null);
//                    }
//
//                    return;
//                }
//                ImageBean bean = GsonUtil.CommonJson(res,ImageBean.class);
//                //Log.d("imagepath",bean.getMax());
//                mRes[index] = bean;
//                list_complete[index] = 1;
//                mListener.starting(index);
////                if(index == mUrls.size()-1){
////                    Log.d("imagepath","complete");
////                    mListener.complete(mRes);
////                }
//
//
//                int count  = 0;
//                L.d("http","size: list_completesize:"+list_complete.length);
//                for(int i = 0; i < list_complete.length; i++){
//                    if(list_complete[i] != 0){
//                        count++;
//                    }
//
//                }
//                if(list_complete.length == count){
//                    ImageBean[] result = DigestUtils.removeArrNull(mRes);
//                    mListener.complete(result);
//                }
//            }
//
//            @Override
//            public void onError(String msg) {
//                L.e("MultiUploadImage","msg:"+msg);
//                list_complete[index] = 2;
//                mListener.onError("第"+index+"张图片上传失败 失败原因:"+msg);
//                if(list_complete.length == 1){
//                    mListener.complete(null);
//                }
//            }
//        },mContext).execute(baseUrl,path,mType);
//    }
//
//    public interface CompleteListener{
//        public void complete(ImageBean[] res);
//        public void starting(int index);
//        public void onError(String msg);
//    }

}
