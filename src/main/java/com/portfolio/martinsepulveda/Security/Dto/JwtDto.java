package com.portfolio.martinsepulveda.Security.Dto;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter @Setter
public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String UserName;
    private Collection<? extends GrantedAuthority> authorities;
    
    //Constructor
    public JwtDto(String token, String UserName, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.UserName = UserName;
        this.authorities = authorities;
    }
    
}
