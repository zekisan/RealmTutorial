package com.example.ezequiel.realm.domain;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Discipline extends RealmObject {
    public static final String ID = "com.example.ezequiel.realm.domain.RealmObject.ID";

    @PrimaryKey
    private long id;
    private String name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
