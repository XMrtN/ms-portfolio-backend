package com.portfolio.martinsepulveda.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectDto {
    @NotBlank
    private String title;
    @NotBlank
    private String subtitle;
    @NotBlank
    private String finishDate;
    @NotBlank
    private String description;
    @NotBlank
    private String img;
    @NotBlank
    private String url;
    
    //Constructors
    public ProyectDto() {
    }
    
    public ProyectDto(String title, String subtitle, String finishDate, String description, String img, String url) {
        this.title = title;
        this.subtitle = subtitle;
        this.finishDate = finishDate;
        this.description = description;
        this.img = img;
        this.url = url;
    }
    
}
