package com.example.goods.Utill;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class Jwtutill {
    private String header;
    private String token;
    private Long expiration;
    public String getToken(){
        return token+" ";
    }
}
