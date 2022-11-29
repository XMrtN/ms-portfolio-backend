package com.portfolio.martinsepulveda.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducationDto {
    @NotBlank
    private int position;
    @NotBlank
    private String edInsTitle;
    @NotBlank
    private String edCareerName;
    @NotBlank
    private String edPeriod;
    @NotBlank
    private String edDesc;
    
    //Constructors
    public EducationDto() {
    }

    public EducationDto(int position, String edInsTitle, String edCareerName, String edPeriod, String edDesc) {
        this.position = position;
        this.edInsTitle = edInsTitle;
        this.edCareerName = edCareerName;
        this.edPeriod = edPeriod;
        this.edDesc = edDesc;
    }
    
}
