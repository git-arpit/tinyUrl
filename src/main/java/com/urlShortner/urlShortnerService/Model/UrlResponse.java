package com.urlShortner.urlShortnerService.Model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


public class UrlResponse {

    String originalUrl;
    String shortUrl;
    LocalDateTime expiryTime;


    public UrlResponse(String originalUrl, String shortUrl, LocalDateTime expiryTime) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.expiryTime = expiryTime;
    }

    public UrlResponse() {
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    @Override
    public String toString() {
        return "UrlResponse{" +
                "originalUrl='" + originalUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", expiryTime=" + expiryTime +
                '}';
    }
}
