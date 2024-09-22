package com.urlShortner.urlShortnerService.Model;

import java.time.LocalDateTime;

public class UrlDto {
    String originalUrl;
    int validity;

    public UrlDto() {
    }

    public UrlDto(String originalUrl, int validity) {
        this.originalUrl = originalUrl;
        this.validity = validity;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public int getValidity() {
        return validity;
    }

    public void setExpiryTime(int validity) {
        this.validity = validity;
    }

    @Override
    public String toString() {
        return "UrlDto{" +
                "originalUrl='" + originalUrl + '\'' +
                ", validity=" + validity +
                '}';
    }
}


