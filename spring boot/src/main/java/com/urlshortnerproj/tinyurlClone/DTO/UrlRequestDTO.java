package com.urlshortnerproj.tinyurlClone.DTO;

public class UrlRequestDTO {
    private String originalUrl;

    public String getOriginalUrl(){
        return this.originalUrl;
    }

    public void setOriginalUrl(String url){
        this.originalUrl=url;
    }

}
