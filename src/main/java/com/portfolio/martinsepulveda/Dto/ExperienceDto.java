package com.portfolio.martinsepulveda.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
    
}
