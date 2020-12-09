package com.spring.boot.demo.SpringDemo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Question {
    @Id
    private int id;
    private String content;
    private String type;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    List<Answer> answerList;
    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "subject_id", referencedColumnName = "subject_id"),
            @JoinColumn(name = "os_content", referencedColumnName = "content")
    })
    private Outputstandard outputstandard;
    private Date modified_date;

    public Question(){}

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getContent(){
        return this.content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }
    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }

    public Outputstandard getOutputstandard() {
        return outputstandard;
    }

    public void setOutputstandard(Outputstandard outputstandard) {
        this.outputstandard = outputstandard;
    }
}
