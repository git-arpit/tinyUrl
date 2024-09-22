package com.urlShortner.urlShortnerService.Model;

import jakarta.persistence.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class UrlModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID urlId;
    @Lob
    private String originalUrl;
    private String shortUrl;
    private LocalDateTime expiryTime;

    public UrlModel(UUID urlId, String originalUrl, String shortUrl, LocalDateTime expiryTime) {
        this.urlId = urlId;
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.expiryTime = expiryTime;
    }

    public UrlModel() {
    }

    public UUID getUrlId() {
        return urlId;
    }

    public void setUrlId(UUID urlId) {
        this.urlId = urlId;
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
        return "UrlModel{" +
                "urlId='" + urlId + '\'' +
                ", originalUrl='" + originalUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", expiryTime=" + expiryTime +
                '}';
    }
}
