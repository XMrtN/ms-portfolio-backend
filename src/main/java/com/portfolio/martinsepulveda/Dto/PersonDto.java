package com.portfolio.martinsepulveda.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonDto {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String description;
    @NotBlank
    private String img;
    
    //Constructors
    public PersonDto() {
    }
    
    public PersonDto(String name, String lastName, String description, String img) {
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        this.img = img;
    }
    
}
