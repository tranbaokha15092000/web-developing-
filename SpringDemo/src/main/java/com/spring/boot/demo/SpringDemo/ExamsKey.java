package com.spring.boot.demo.SpringDemo;

import java.io.Serializable;
import java.util.Date;

public class ExamsKey implements Serializable {
    private Subject subject;
    private Date exam_date;
    private String id;

    public ExamsKey() {}

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
}
