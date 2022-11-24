package com.portfolio.martinsepulveda.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienceDto {
    @NotBlank
    private String expCompName;
    @NotBlank
    private String expJobTitle;
    @NotBlank
    private String expPeriod;
    @NotBlank
    private String expDesc;
    
    //Constructors
    public ExperienceDto() {
    }

    public ExperienceDto(String expCompName, String expJobTitle, String expPeriod, String expDesc) {
        this.expCompName = expCompName;
        this.expJobTitle = expJobTitle;
        this.expPeriod = expPeriod;
        this.expDesc = expDesc;
    }
    
}
