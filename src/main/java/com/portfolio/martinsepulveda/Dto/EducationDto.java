package com.portfolio.martinsepulveda.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
    
}
