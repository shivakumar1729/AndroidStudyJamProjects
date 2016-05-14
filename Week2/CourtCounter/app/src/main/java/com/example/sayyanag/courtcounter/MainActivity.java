package com.example.sayyanag.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int teamAScore = 0;
    int teamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * Increment the score for Team A by 1 Point
     */
    public void addOnePointForA(View v){
        teamAScore = teamAScore + 1;
        displayForTeamA(teamAScore);
    }

    /*
     * Increment the score for Team A by 2 Points
     */
    public void addTwoPointsForA(View v){
        teamAScore = teamAScore + 2;
        displayForTeamA(teamAScore);
    }

    /*
     * Increment the score for Team A by 3 Points
     */
    public void addThreePointsForA(View v){
        teamAScore = teamAScore + 3;
        displayForTeamA(teamAScore);
    }

    /*
     * Increment the score for Team B by 1 Point
     */
    public void addOnePointForB(View v){
        teamBScore = teamBScore + 1;
        displayForTeamB(teamBScore);
    }

    /*
     * Increment the score for Team B by 2 Points
     */
    public void addTwoPointsForB(View v){
        teamBScore = teamBScore + 2;
        displayForTeamB(teamBScore);
    }

    /*
     * Increment the score for Team B by 3 Points
     */
    public void addThreePointsForB(View v){
        teamBScore = teamBScore + 3;
        displayForTeamB(teamBScore);
    }

    /*
     * Displays the given score for Team A
     */
    public void displayForTeamA(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /*
     * Displays the given score for Team B
     */
    public void displayForTeamB(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /*
     * Resets the scores for both Teams
     */
    public void resetScores(View v){
        teamAScore = 0;
        teamBScore = 0;
        displayForTeamA(teamAScore);
        displayForTeamB(teamBScore);
    }
}
