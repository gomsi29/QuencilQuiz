package com.ankur.quencilquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizLayout extends AppCompatActivity implements View.OnClickListener {
TextView totalQuestions,questions;
Button ans1,ans2,ans3,ans4,submitBtn;
int score=0;
int totalNoOfQuestions = quizModel.questions.length;
int currentQuestionIndex=0;
String selectAnswer="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_layout);
        getSupportActionBar().hide();

        totalQuestions=findViewById(R.id.total_question);
        questions=findViewById(R.id.questions);
        ans1=findViewById(R.id.Button1);
        ans2=findViewById(R.id.Button2);
        ans3=findViewById(R.id.Button3);
        ans4=findViewById(R.id.Button4);
        submitBtn=findViewById(R.id.SubmitButton);


        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestions.setText("Total Questions : "+totalNoOfQuestions);
        loadNewQuestion();




    }

    private void loadNewQuestion() {
       if (currentQuestionIndex==totalNoOfQuestions)
       {
           finishQuiz();

       }



        totalQuestions.setText(quizModel.NoOfQuestions[currentQuestionIndex]);
        questions.setText(quizModel.questions[currentQuestionIndex]);
        ans1.setText(quizModel.choices[currentQuestionIndex][0]);
        ans2.setText(quizModel.choices[currentQuestionIndex][1]);
        ans3.setText(quizModel.choices[currentQuestionIndex][2]);
        ans4.setText(quizModel.choices[currentQuestionIndex][3]);
    }

    private void finishQuiz() {

        Intent intent= new Intent(getApplicationContext(),ResultActivity.class);
        intent.putExtra("Score",score);
        intent.putExtra("currentIndex",currentQuestionIndex);
        startActivity(intent);

    }


    @Override
    public void onClick(View v) {

        ans1.setBackgroundColor(Color.WHITE);
        ans2.setBackgroundColor(Color.WHITE);
        ans3.setBackgroundColor(Color.WHITE);
        ans4.setBackgroundColor(Color.WHITE);

        Button clickButton=(Button) v;
        if (clickButton.getId()==R.id.SubmitButton)
        {
            if (selectAnswer.equals(quizModel.correctAnswer[currentQuestionIndex]))
            {
                score++;
            }
              currentQuestionIndex++;
              loadNewQuestion();

        }
        else
        {
             selectAnswer=clickButton.getText().toString();
             clickButton.setBackgroundColor(R.drawable.button);
        }

    }
}