package com.portfolio.martinsepulveda.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Colors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String firstColor;
    private String secondColor;
    
    //Constructors
    public Colors() {
    }

    public Colors(String firstColor, String secondColor) {
        this.firstColor = firstColor;
        this.secondColor = secondColor;
    }
    
}
