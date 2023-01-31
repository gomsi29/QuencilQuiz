package com.ankur.quencilquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
TextView result;
Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().hide();
        Intent fromActivity = getIntent();
        int score = fromActivity.getIntExtra("Score",0);
        int currentQuestionIndex=fromActivity.getIntExtra("currentIndex",0);
        result=findViewById(R.id.result);
        restart=findViewById(R.id.restart);

        result.setText("You Score "+score+" Out Of "+currentQuestionIndex);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score=0;
                int currentQuestionIndex=0;

                Intent intent = new Intent(getApplicationContext(),QuizLayout.class);
                intent.putExtra("Score",score);
                intent.putExtra("currentIndex",currentQuestionIndex);
                startActivity(intent);
            }
        });

    }
}