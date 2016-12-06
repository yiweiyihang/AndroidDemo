package com.example.android.miwok;

/**
 * Created by 32618 on 2016/12/5.
 * 包括miwok 和English 两个单词
 */

public class Word {
    private String mMiwokTran;
    private String mEngTran;
    private int mImageViewId = NO_IMAGE_PROVIDED;
    private int mMediaId;

    private static final int NO_IMAGE_PROVIDED = -1;
    // 构造函数
    public Word(String miwok,String eng,int imageId,int mediaId){
        mMiwokTran = miwok;
        mEngTran = eng;
        mImageViewId = imageId;
        mMediaId = mediaId;
    }
    // 构造函数重载  处理phrases不需要添加图片的情况
    public Word(String miwork,String eng,int mediaId){
        mMiwokTran = miwork;
        mEngTran = eng;
        mMediaId = mediaId;
    }

    // Get the Miwok Translation of the Word.
    public String getMiwokTran(){
        return mMiwokTran;
    }

    // Get the English Translation of the Word
    public String getEngTran(){
        return mEngTran;
    }

    // Get the ImageView ID of the Word
    public int getmImageViewId(){return mImageViewId;}

    // Check if the Word has Image
    public boolean hasImage(){
//        if(mImageViewId != NO_IMAGE_PROVIDED){
//            return true;
//        }
//        return false;
        return mImageViewId != NO_IMAGE_PROVIDED;
    }
    public int getmMediaId(){return mMediaId;}

}
