package com.example.henry.numbersgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class NumbersGame extends AppCompatActivity {
    int num1;
    int num2;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_game);
        updateNumbers();
    }

    public void updateNumbers() {
        Random ranGen = new Random();
        num1 = 0;
        num2 = 0;
        while(num1 == num2) {
            num1 = ranGen.nextInt(100);
            num2 = ranGen.nextInt(100);
        }

        Button lButton = (Button) findViewById(R.id.lButton);
        Button rButton = (Button) findViewById(R.id.rButton);

        lButton.setText(String.valueOf(num1));
        rButton.setText(String.valueOf(num2));
    }

    public void rightButtonClick(View view) {
        if(num2 > num1) {
            Toast.makeText(this, "You guessed correctly!", Toast.LENGTH_SHORT).show();
            points++;
            updateNumbers();
        } else {
            Toast.makeText(this, "You dumb as heck!", Toast.LENGTH_SHORT).show();
            points--;
            updateNumbers();
        }

        TextView pointText = (TextView) findViewById(R.id.points);
        pointText.setText("Points: " + points);
    }

    public void leftButtonClick(View view) {
        if(num1 > num2) {
            Toast.makeText(this, "You guessed correctly!", Toast.LENGTH_SHORT).show();
            points++;
            updateNumbers();
        } else {
            Toast.makeText(this, "You dumb as heck!", Toast.LENGTH_SHORT).show();
            points--;
            updateNumbers();
        }
        TextView pointText = (TextView) findViewById(R.id.points);
        pointText.setText("Points: " + points);
    }
}
