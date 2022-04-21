package com.mwt.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class NeoProperties {

    @Value("${com.mwt.title}")
    private String tiutle;

    @Value("com.mwt.description")
    private String description;

    public String getTiutle() {
        return tiutle;
    }

    public void setTiutle(String tiutle) {
        this.tiutle = tiutle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
