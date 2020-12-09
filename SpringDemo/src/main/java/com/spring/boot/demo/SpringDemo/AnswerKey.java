package com.spring.boot.demo.SpringDemo;

import java.io.Serializable;

public class AnswerKey implements Serializable {
    private String id;
    private Question question;

    public AnswerKey() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
