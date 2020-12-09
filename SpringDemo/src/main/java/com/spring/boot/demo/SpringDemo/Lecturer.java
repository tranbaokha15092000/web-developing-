package com.spring.boot.demo.SpringDemo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lecturer {
    @Id
    @JsonIgnore
    private String id;
    @OneToOne
    @JoinColumn(name = "id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonIgnore
    private Subject subject;
    @OneToMany(mappedBy = "lecturer", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Question> questionList;

    public Lecturer(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
