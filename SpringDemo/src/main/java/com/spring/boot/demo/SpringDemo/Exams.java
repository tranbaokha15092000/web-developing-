package com.spring.boot.demo.SpringDemo;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(ExamsKey.class)
public class Exams {
    @Id
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @Id
    private Date exam_date;
    @Id
    private String id;
    private int term;
    private Date startdate;
    private Date enddate;

    public Exams() {}

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getExam_date() {
        return exam_date;
    }

    public void setExam_date(Date exam_date) {
        this.exam_date = exam_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
}
