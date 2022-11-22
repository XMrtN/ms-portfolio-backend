package com.portfolio.martinsepulveda.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String subtitle;
    private String description;
    private String img;
    private String url;
    
    //Constructors
    public Proyect() {
    }

    public Proyect(String title, String subtitle, String description, String img, String url) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.img = img;
        this.url = url;
    }
    
}
