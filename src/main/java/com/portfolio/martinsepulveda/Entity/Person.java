package com.portfolio.martinsepulveda.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longitud inválida")
    private String name;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Longitud inválida")
    private String lastName;
    
    @NotNull
    private String description;
    
    private String img;
    
    //Constructors
    public Person() {
    }

    public Person(String name, String lastName, String description, String img) {
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        this.img = img;
    }
    
}
