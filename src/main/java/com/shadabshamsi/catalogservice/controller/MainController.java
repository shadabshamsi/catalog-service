package com.shadabshamsi.catalogservice.controller;

import com.shadabshamsi.catalogservice.config.PolarProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MainController {

    private final PolarProperties polarProperties;

    public MainController(PolarProperties polarProperties) {
        this.polarProperties = polarProperties;
    }

    @GetMapping
    public String get() {
        return polarProperties.getGreeting();
    }
}
