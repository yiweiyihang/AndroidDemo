package com.yiweiyihangft.opencvtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView pikaqiu;
    private Button grayBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pikaqiu = (ImageView)findViewById(R.id.picture);
        grayBt = (Button)findViewById(R.id.gray_bt);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.gray_bt:

        }
    }
}
