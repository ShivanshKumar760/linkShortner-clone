package com.urlshortnerproj.tinyurlClone.Mapper;

import com.urlshortnerproj.tinyurlClone.DTO.UrlRequestDTO;
import com.urlshortnerproj.tinyurlClone.Entity.UrlMapping;
import com.urlshortnerproj.tinyurlClone.DTO.UrlResponseDTO;
import java.util.Base64;
public class UrlMapper {
    public static UrlMapping toEntity(UrlRequestDTO reqDto,String shortCode,byte[] qrCode,UrlMapping entity){
            entity.setOriginalUrl(reqDto.getOriginalUrl());
            entity.setShortUrl(shortCode);
            entity.setQrCode(qrCode);
            return entity;

    }

    public static UrlResponseDTO toResponse(
            UrlMapping entity,
            String baseUrl
    ) {
        return new UrlResponseDTO(
                entity.getOriginalUrl(),
                baseUrl + entity.getShortUrl(),
                Base64.getEncoder().encodeToString(entity.getQrCode())
        );
    }
}
