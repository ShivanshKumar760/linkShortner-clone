package com.urlshortnerproj.tinyurlClone.DTO;

public class UrlResponseDTO {
    private final String originalUrl;
    private final String shortUrl;
    private final String qrCodeBase64;

    public UrlResponseDTO(String ogUrl,String shortUrl,String qrCode){
        this.originalUrl=ogUrl;
        this.shortUrl=shortUrl;
        this.qrCodeBase64=qrCode;

    }


    public String getOriginalUrl(){
        return this.originalUrl;

    }

    public String getShortUrl(){
        return this.shortUrl;
    }

    public String getQrCodeBase64(){
        return this.qrCodeBase64;
    }
}

