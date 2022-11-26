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
    private String email;
    @NotBlank
    private String img;
    @NotBlank
    private String cv;
    
    //Constructors
    public PersonDto() {
    }
    
    public PersonDto(String name, String lastName, String description, String email, String img, String cv) {
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        this.email = email;
        this.img = img;
        this.cv = cv;
    }
    
}
