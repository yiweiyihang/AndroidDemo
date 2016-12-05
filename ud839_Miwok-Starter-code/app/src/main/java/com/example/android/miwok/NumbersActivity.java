package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word>  words = new ArrayList<>();
        // example to add words to ArrayList
        Word w = new Word("lutti","one");
        words.add(w);
        //简化语句
        words.add(new Word("ottiiko","two"));
        words.add(new Word("tolookosu","three"));
        words.add(new Word("oyyisa","four"));
        words.add(new Word("masokka","five"));
        words.add(new Word("temmokka","six"));
        words.add(new Word("kenekaku","seven"));
        words.add(new Word("kawinta","eight"));
        words.add(new Word("wo'e","nine"));
        words.add(new Word("na'aacha","ten"));

        WordAdapter itemsAdapter = new WordAdapter(this,words);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
