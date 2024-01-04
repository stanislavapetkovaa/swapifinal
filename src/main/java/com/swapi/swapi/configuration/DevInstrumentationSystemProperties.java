package com.swapi.swapi.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import lombok.Data;
import lombok.Getter;

@Profile("dev")
@ConfigurationProperties("mylogging")
@Configuration
@Data
public class DevInstrumentationSystemProperties {

    public String username;
    public String password;
}
