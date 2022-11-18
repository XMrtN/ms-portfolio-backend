package com.portfolio.martinsepulveda.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FrontSkillDto {
    @NotBlank
    private String name;
    @NotBlank
    private int percentage;
    
    //Constructors
    public FrontSkillDto() {
    }

    public FrontSkillDto(String name, int percentage) {
        this.name = name;
        this.percentage = percentage;
    }
}
