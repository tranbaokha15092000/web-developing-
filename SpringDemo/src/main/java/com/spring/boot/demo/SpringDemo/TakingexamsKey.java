package com.spring.boot.demo.SpringDemo;

import java.io.Serializable;
import java.util.Date;

public class TakingexamsKey implements Serializable {
    private Subject subject;
    private Date exam_date;

    public TakingexamsKey() {}

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
}
