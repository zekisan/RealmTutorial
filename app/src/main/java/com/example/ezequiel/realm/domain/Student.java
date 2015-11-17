package com.example.ezequiel.realm.domain;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Student extends RealmObject{
    public static final String ID = "com.example.ezequiel.realm.domain.RealmObject.ID";

    @PrimaryKey
    private long id;
    private String name;
    private String email;
    private RealmList<Grade> grades;

    public static String getID() {
        return ID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RealmList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(RealmList<Grade> grades) {
        this.grades = grades;
    }
}
