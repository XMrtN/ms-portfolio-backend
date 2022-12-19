package com.portfolio.martinsepulveda.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ColorsDto {
    @NotBlank
    private int firstColor;
    @NotBlank
    private String secondColor;
    
    //Constructors
    public ColorsDto() {
    }

    public ColorsDto(int firstColor, String secondColor) {
        this.firstColor = firstColor;
        this.secondColor = secondColor;
    }
    
}
