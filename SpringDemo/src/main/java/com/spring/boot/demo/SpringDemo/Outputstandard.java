package com.spring.boot.demo.SpringDemo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@IdClass(OutputStandardKey.class)
public class Outputstandard {
    @Id
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @Id
    private String content;
    @OneToMany(mappedBy = "outputstandard",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Question> questionList;

    public Outputstandard() {}

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
