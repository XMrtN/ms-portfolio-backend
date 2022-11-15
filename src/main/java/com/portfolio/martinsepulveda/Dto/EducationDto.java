package com.portfolio.martinsepulveda.Dto;

import javax.validation.constraints.NotBlank;

public class EducationDto {
    @NotBlank
    private String edName;
    @NotBlank
    private String edDesc;
    
    //Constructors
    public EducationDto() {
    }

    public EducationDto(String edName, String edDesc) {
        this.edName = edName;
        this.edDesc = edDesc;
    }
    
    //Getters and Setters
    public String getEdName() {
        return edName;
    }

    public void setEdName(String edName) {
        this.edName = edName;
    }

    public String getEdDesc() {
        return edDesc;
    }

    public void setEdDesc(String edDesc) {
        this.edDesc = edDesc;
    }
    
}
