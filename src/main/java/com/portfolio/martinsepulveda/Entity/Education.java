package com.portfolio.martinsepulveda.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String edInsTitle;
    private String edCareerName;
    private String edPeriod;
    private String edDesc;
    
    //Constructors
    public Education() {
    }

    public Education(String edInsTitle, String edCareerName, String edPeriod, String edDesc) {
        this.edInsTitle = edInsTitle;
        this.edCareerName = edCareerName;
        this.edPeriod = edPeriod;
        this.edDesc = edDesc;
    }
    
}
