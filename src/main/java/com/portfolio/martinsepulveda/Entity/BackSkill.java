package com.portfolio.martinsepulveda.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class BackSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int percentage;
    
    //Constructors
    public BackSkill() {
    }

    public BackSkill(String name, int percentage) {
        this.name = name;
        this.percentage = percentage;
    }
    
}
