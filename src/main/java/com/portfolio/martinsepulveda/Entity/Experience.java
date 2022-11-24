package com.portfolio.martinsepulveda.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String expCompName;
    private String expJobTitle;
    private String expPeriod;
    private String expDesc;
    
    //Constructors
    public Experience() {
    }

    public Experience(String expCompName, String expJobTitle, String expPeriod, String expDesc) {
        this.expCompName = expCompName;
        this.expJobTitle = expJobTitle;
        this.expPeriod = expPeriod;
        this.expDesc = expDesc;
    }
    
}
