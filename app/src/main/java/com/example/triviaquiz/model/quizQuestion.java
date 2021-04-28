package com.example.triviaquiz.model;

public class quizQuestion {

    private String questiontext;
    private boolean trueAnswer;

    public quizQuestion(String questiontext, boolean trueAnswer) {
        this.questiontext = questiontext;
        this.trueAnswer = trueAnswer;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    public boolean isTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(boolean trueAnswer) {
        this.trueAnswer = trueAnswer;
    }
}
