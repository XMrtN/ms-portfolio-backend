package com.portfolio.martinsepulveda.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String edName;
    private String edDesc;
    
    //Constructors
    public Education() {
    }

    public Education(String edName, String edDesc) {
        this.edName = edName;
        this.edDesc = edDesc;
    }
    
    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEdName() {
        return edName;
    }

    public void setEdName(String edName) {
        this.edName = edName;
    }

    public String getEdDesc() {
        return edDesc;
    }

    public void setEdDesc(String edDesc) {
        this.edDesc = edDesc;
    }
    
}
