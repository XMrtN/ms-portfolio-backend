package com.portfolio.martinsepulveda.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BackSkillDto {
    @NotBlank
    private String name;
    @NotBlank
    private int percentage;
    
    //Constructors
    public BackSkillDto() {
    }

    public BackSkillDto(String name, int percentage) {
        this.name = name;
        this.percentage = percentage;
    }
}
