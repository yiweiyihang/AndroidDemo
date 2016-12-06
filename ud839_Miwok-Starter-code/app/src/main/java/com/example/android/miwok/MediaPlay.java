package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by 32618 on 2016/12/6.
 */

public class MediaPlay {
    private ListView mListView;
    private Context mContext;
    public MediaPlay(ListView listView, Context context){
        mListView = listView;
        mContext = context;
    }
    public  void mediaPlay(){
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word currentWord = (Word)parent.getItemAtPosition(position);
                MediaPlayer mediaPlayer = MediaPlayer.create(mContext,currentWord.getmMediaId());
                mediaPlayer.start();
            }
        });
    }
}
