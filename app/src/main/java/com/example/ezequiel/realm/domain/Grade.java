package com.example.ezequiel.realm.domain;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Grade extends RealmObject{

    public static final String ID = "com.example.ezequiel.realm.domain.RealmObject.ID";

    @PrimaryKey
    private long id;

    private Discipline discipline;
    private double grade;

    public static String getID() {
        return ID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
