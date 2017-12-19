package com.howtographql.hackernews;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author Alexander Pyreev
 */
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "spring.data.mongodb")
@Validated
public class ConfigProperties {
    @NotBlank
    @Getter
    @Setter
    private String uri;
    @NotBlank
    @Getter
    @Setter
    private String host;
    @Min(1025)
    @Max(65536)
    @Getter
    @Setter
    private int port;
    @Getter
    @Setter
    private String database;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
}
