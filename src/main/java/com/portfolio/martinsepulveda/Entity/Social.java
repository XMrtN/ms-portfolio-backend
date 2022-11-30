package com.portfolio.martinsepulveda.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Social {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int position;
    private String icon;
    private String url;
    
    //Constructors
    public Social() {
    }

    public Social(int position, String icon, String url) {
        this.position = position;
        this.icon = icon;
        this.url = url;
    }
}
