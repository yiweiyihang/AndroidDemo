package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
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
    private MediaPlayer mMediaPlayer;


    public MediaPlay(ListView listView, Context context) {
        mListView = listView;
        mContext = context;
    }

    AudioManager am;
    private AudioManager.OnAudioFocusChangeListener afChangeListener =
            (new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    switch (focusChange) {
                        // The AUDIOFOCUS_GAIN means we have regained focus and can resume playback
                        case AudioManager.AUDIOFOCUS_GAIN:
                            mMediaPlayer.start();
                            break;
                        // The AUDIOFOCUS_LOSS means we've lost audio focus
                        // and stop playback and cleanup resources
                        case AudioManager.AUDIOFOCUS_LOSS:
                            releaseMediaPlayer();
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                            mMediaPlayer.pause();
                            mMediaPlayer.seekTo(0);  // 使用户能够从头听单词发音 而不是从中间继续
                            break;
                    }
                }
            });

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {

            releaseMediaPlayer();

        }
    };

    /*
    创建MediaPlayer实例 并监听状态  播放完毕后释放资源
     */
    public void mediaPlay() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word currentWord = (Word) parent.getItemAtPosition(position);


                // Create an setup the AudioManager to request audio focus
                am = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
                // Release the media player if it currently exists
                // because we are about to play a different sound file
                releaseMediaPlayer();
                // Request audio focus for playback
                int result = am.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // this focus request is temporary, and focus will be abandonned shortly
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // we have audio focus now
                    mMediaPlayer = MediaPlayer.create(mContext, currentWord.getmMediaId());
                    mMediaPlayer.start();
                    // 创建全局变量
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }


            }
        });
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    public void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
            am.abandonAudioFocus(afChangeListener);
        }
    }
}
