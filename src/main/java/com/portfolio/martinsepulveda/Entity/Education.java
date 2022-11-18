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
    private String edName;
    private String edDesc;
    
    //Constructors
    public Education() {
    }

    public Education(String edName, String edDesc) {
        this.edName = edName;
        this.edDesc = edDesc;
    }
    
}
