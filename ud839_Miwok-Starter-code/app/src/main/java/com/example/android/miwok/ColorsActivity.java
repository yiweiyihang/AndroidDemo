package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<>();
        // example to add words to ArrayList

        //简化语句
        words.add(new Word("weṭeṭṭi","red"));
        words.add(new Word("chokokki","green"));
        words.add(new Word("ṭakaakki","brown"));
        words.add(new Word("ṭopoppi","gray"));
        words.add(new Word("kululli","black"));
        words.add(new Word("kelelli","white"));
        words.add(new Word("ṭopiisә","dusty yellow"));
        words.add(new Word("chiwiiṭә","mustard yellow"));

        WordAdapter itemsAdapter = new WordAdapter(this,words);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
