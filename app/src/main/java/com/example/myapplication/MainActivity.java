package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    TextView pointsTextView;

    ArrayList<question> questions = new ArrayList<>();
    Button button1;
    Button button2;


    int points;
    private int currentQuestionIndex = 0;
    boolean answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillQuestionsWithData();

        myTextView = findViewById(R.id.textQuestion);
        pointsTextView = findViewById(R.id.textPoints);
        button1 = findViewById(R.id.buttonone);
        button2 = findViewById(R.id.buttontwo);


        button1.setOnClickListener(v -> {
            checkQuestion(true);
        });

        button2.setOnClickListener(v -> {
            checkQuestion(false);
        });

        updateQuestion();
    }
    void fillQuestionsWithData(){
        questions.add(new question("Utilitzem Java per a programar Android",true));
        questions.add(new question("Per a programar amb React utilitzem Python",false));
        questions.add(new question("Puc fer un programa per a iphone amb android",false));
        questions.add(new question("El llenguatge més utilitzar per a programar en front en JavaScript",true));
        questions.add(new question("Puc escriure a number el número en forma de string",false));
        questions.add(new question("Una array pot contenir numbers o stings",true));
        questions.add(new question("programar es fàcil",false));
        questions.add(new question("Puc utilitzar JavaScript per a programar el backend de la meva aplicació web",true));
        questions.add(new question("Puc utilitzar React en Java",false));
        questions.add(new question("Java es un llenguatge tipat",true));

    }
    void updateQuestion() {
        if (currentQuestionIndex >= questions.size()) {
            currentQuestionIndex = 0;
        }
        question myQuestion = questions.get(currentQuestionIndex);
        String questionTitle = myQuestion.getQuestionTitle();
        myTextView.setText(questionTitle);
    }


    void checkQuestion(boolean userAnswer){

        if(questions.get(currentQuestionIndex).answerIsTrue() == userAnswer){
            Toast.makeText(this,"Correct!", Toast.LENGTH_SHORT).show();
            points++;
        }else{
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
            points--;
        }
        currentQuestionIndex++;
        if(currentQuestionIndex == questions.size()){
            moveToResultsScreen();
        } else {
            updateQuestion();
        }
        pointsTextView.setText("Points: " + points);
    }


    void updatePoints(){
        String pointsText = "Puntos: " + points;
        pointsTextView.setText(pointsText);
    }

    void moveToResultsScreen(){
        Intent intent = new Intent( this, ResultActivity.class);
        intent.putExtra("score",5);
        startActivity(intent);
    }
}