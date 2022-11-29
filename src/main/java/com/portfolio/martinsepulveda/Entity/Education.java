package com.portfolio.martinsepulveda.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int position;
    private String edInsTitle;
    private String edCareerName;
    private String edPeriod;
    private String edDesc;
    
    //Constructors
    public Education() {
    }

    public Education(int position, String edInsTitle, String edCareerName, String edPeriod, String edDesc) {
        this.position = position;
        this.edInsTitle = edInsTitle;
        this.edCareerName = edCareerName;
        this.edPeriod = edPeriod;
        this.edDesc = edDesc;
    }
    
}
