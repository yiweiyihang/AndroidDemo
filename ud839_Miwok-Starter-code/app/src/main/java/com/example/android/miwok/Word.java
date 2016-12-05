package com.example.android.miwok;

/**
 * Created by 32618 on 2016/12/5.
 * 包括miwok 和English 两个单词
 */

public class Word {
    private String mMiwokTran;
    private String mEngTran;

    // 构造函数
    public Word(String miwok,String eng){
        mMiwokTran = miwok;
        mEngTran = eng;
    }

    // Get the Miwok Translation of the Word.
    public String getMiwokTran(){
        return mMiwokTran;
    }

    // Get the English Translation of the Word
    public String getEngTran(){
        return mEngTran;
    }

}
