package com.springbootdemo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "benson")
@Data
public class Benson {
    private String title;
    private String description;
}
