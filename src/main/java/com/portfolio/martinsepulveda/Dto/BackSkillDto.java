package com.portfolio.martinsepulveda.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BackSkillDto {
    @NotBlank
    private int position;
    @NotBlank
    private String name;
    @NotBlank
    private int percentage;
    
    //Constructors
    public BackSkillDto() {
    }

    public BackSkillDto(int position, String name, int percentage) {
        this.position = position;
        this.name = name;
        this.percentage = percentage;
    }
}
