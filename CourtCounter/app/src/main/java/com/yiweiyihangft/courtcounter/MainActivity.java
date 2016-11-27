package com.yiweiyihangft.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int scoreA = 0;
    private int scoreB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        displayForTeamA(8);
    }

    public  void addThreeForTeamA(View v){
        scoreA +=3;
        displayForTeamA(scoreA);
    }
    public  void addThreeForTeamB(View v){
        scoreB +=3;
        displayForTeamB(scoreB);
    }

    public  void addTwoForTeamA(View v){
        scoreA +=2;
        displayForTeamA(scoreA);
    }
    public  void addTwoForTeamB(View v){
        scoreB +=2;
        displayForTeamB(scoreB);
    }

    public  void addOneForTeamA(View v){
        scoreA +=1;
        displayForTeamA(scoreA);
    }
    public  void addOneForTeamB(View v){
        scoreB +=1;
        displayForTeamB(scoreB);
    }

    public void resetScore(View v){
        scoreA = 0;
        scoreB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score){
        TextView scoreView = (TextView)findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

}
