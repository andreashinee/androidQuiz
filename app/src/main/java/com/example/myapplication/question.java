package com.example.myapplication;

public class question {
    private String questionTitle;
    private boolean answer;

    public question(String questionTitle, boolean answer) {
        this.questionTitle = questionTitle;
        this.answer = answer;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public boolean answerIsTrue() {
        return answer;
    }

}