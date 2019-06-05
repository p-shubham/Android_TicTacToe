package com.personal.crosstick;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int [][] clickVars = {{2,2,2},{2,2,2},{2,2,2}};
    int playerNum = 0;

    public void checkForWinner(){
        for(int i = 0; i < 3 ; i++) {
            //row
            if((clickVars[i][0] == clickVars[i][1]) && (clickVars[i][1] == clickVars[i][2])) {
                if (clickVars[i][0] == 0) {
                    Toast.makeText(getApplicationContext(), "Player 0 is Winner", Toast.LENGTH_LONG).show();
                } else if (clickVars[i][0] == 1) {
                    Toast.makeText(getApplicationContext(), "Player 1 is Winner", Toast.LENGTH_LONG).show();
                }
            }
            //column
            if((clickVars[0][i] == clickVars[1][i]) && (clickVars[1][i] == clickVars[2][i])) {
                if (clickVars[0][i] == 0) {
                    Toast.makeText(getApplicationContext(), "Player 0 is Winner", Toast.LENGTH_LONG).show();
                } else if (clickVars[0][i] == 1) {
                    Toast.makeText(getApplicationContext(), "Player 1 is Winner", Toast.LENGTH_LONG).show();
                }
            }
        }
        checkDiagonalWinner();
    }
    public void checkDiagonalWinner(){
        //diagonal
        if((clickVars[0][0] == clickVars[1][1]) && (clickVars[0][0] == clickVars[2][2])){
            if(clickVars[0][0] == 0) {
                Toast.makeText(getApplicationContext(),"Player 0 is Winner",Toast.LENGTH_LONG).show();
            }
            else if(clickVars[0][0] == 1){
                Toast.makeText(getApplicationContext(),"Player 1 is Winner",Toast.LENGTH_LONG).show();
            }
        }
    }
    public void bringOnClick(View view){
        ImageView chance = (ImageView) view;
        String parse = String.valueOf(chance.getTag());
        String rowString = parse.substring(0,1);
        int row = Integer.parseInt(rowString);
        int column = Integer.parseInt(parse) % 10;
        if(chance.getDrawable() == null) {
            if (playerNum == 0) {
                chance.setImageResource(R.drawable.yellow);
                chance.animate().alpha(1f).setDuration(250);
                playerNum = 1;
                clickVars[row][column] = 0;
            } else if (playerNum == 1) {
                chance.setImageResource(R.drawable.red);
                chance.animate().alpha(1f).setDuration(250);
                playerNum = 0;
                clickVars[row][column] = 1;
            }
        }
        checkForWinner();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
