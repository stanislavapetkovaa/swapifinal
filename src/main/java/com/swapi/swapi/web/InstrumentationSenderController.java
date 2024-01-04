package com.swapi.swapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.swapi.swapi.configuration.DevInstrumentationSender;

public class InstrumentationSenderController {

    @Autowired
    DevInstrumentationSender devInstrumentationSender;

    @GetMapping("/sendDevStatics")
    public void sendDevStatics() {
        devInstrumentationSender.sendStatistic();
    }

}
