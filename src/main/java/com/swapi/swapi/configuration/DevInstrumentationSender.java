package com.swapi.swapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.Getter;

@Component
@Data
@Profile("dev")
public class DevInstrumentationSender {
    @Autowired
    private DevInstrumentationSystemProperties config;

    public void sendStatistic() {
        System.out.println(config.getUsername());
    }
}
