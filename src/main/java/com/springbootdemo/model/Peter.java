package com.springbootdemo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "peter")
@PropertySource("classpath:other.properties")
@Data
public class Peter {
    private String title;
    private String description;
}
