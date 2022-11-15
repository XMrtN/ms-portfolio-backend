package com.portfolio.martinsepulveda.Dto;

import javax.validation.constraints.NotBlank;

public class ExperienceDto {
    @NotBlank
    private String expName;
    @NotBlank
    private String expDesc;
    
    //Constructors
    public ExperienceDto() {
    }

    public ExperienceDto(String expName, String expDesc) {
        this.expName = expName;
        this.expDesc = expDesc;
    }
    
    //Getters and Setters
    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getExpDesc() {
        return expDesc;
    }

    public void setExpDesc(String expDesc) {
        this.expDesc = expDesc;
    }
    
}
