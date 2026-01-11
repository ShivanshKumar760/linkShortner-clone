package com.urlshortnerproj.tinyurlClone.Entity;

import jakarta.persistence.*;
@Entity
public class UrlMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalUrl;

    @Column(unique = true)
    private String shortUrl;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] qrCode;

    // getters & setters
    public Long getId() {
        return id;
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

    public byte[] getQrCode() {
        return qrCode;
    }

    public void setQrCode(byte[] qrCode) {
        this.qrCode = qrCode;
    }
}
