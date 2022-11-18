package com.portfolio.martinsepulveda.Security.Controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Message {
    private String message;
    
    //Constructors
    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }
    
}
