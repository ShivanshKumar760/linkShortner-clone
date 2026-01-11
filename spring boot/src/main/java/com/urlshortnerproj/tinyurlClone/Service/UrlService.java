package com.urlshortnerproj.tinyurlClone.Service;

import com.urlshortnerproj.tinyurlClone.DTO.UrlRequestDTO;
import com.urlshortnerproj.tinyurlClone.DTO.UrlResponseDTO;
import com.urlshortnerproj.tinyurlClone.Entity.UrlMapping;
import com.urlshortnerproj.tinyurlClone.Mapper.UrlMapper;
import com.urlshortnerproj.tinyurlClone.Repository.UrlRepository;
import com.urlshortnerproj.tinyurlClone.util.QRCodeGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {
    private final UrlRepository repo;
    private static final String BASE_URL = "http://localhost:8080/";
    public UrlService(UrlRepository repo){
        this.repo=repo;
    }

    //controller to shorten the url
    public UrlResponseDTO shorten(UrlRequestDTO request){
        String shortCode = UUID.randomUUID().toString().substring(0, 6);
        String fullShortUrl =  BASE_URL + shortCode;
        byte[] qrCode= QRCodeGenerator.generateQr(fullShortUrl);
        UrlMapping returnEntity=UrlMapper.toEntity(request,shortCode,qrCode,new UrlMapping());
        repo.save(returnEntity);
        return UrlMapper.toResponse(returnEntity,BASE_URL);
    }
    public String getOriginal(String code) {
        return repo.findByShortUrl(code)
                .orElseThrow(() -> new RuntimeException("URL not found"))
                .getOriginalUrl();
    }

    public byte[] getQr(String code) {
        return repo.findByShortUrl(code)
                .orElseThrow(() -> new RuntimeException("URL not found"))
                .getQrCode();
    }
}
