package com.spring.boot.demo.SpringDemo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subject {
    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<Lecturer> lecturerList;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<Outputstandard> outputstandardList;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<Takingexams> takingexams;

    public Subject(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lecturer> getLecturerList() {
        return lecturerList;
    }

    public void setLecturerList(List<Lecturer> lecturerList) {
        this.lecturerList = lecturerList;
    }

    public List<Outputstandard> getOutputStandardList() {
        return outputstandardList;
    }

    public void setOutputStandardList(List<Outputstandard> outputStandardList) {
        this.outputstandardList = outputstandardList;
    }

    public List<Outputstandard> getOutputstandardList() {
        return outputstandardList;
    }

    public List<Takingexams> getTakingexams() {
        return takingexams;
    }

    public void setTakingexams(List<Takingexams> takingexams) {
        this.takingexams = takingexams;
    }
}
