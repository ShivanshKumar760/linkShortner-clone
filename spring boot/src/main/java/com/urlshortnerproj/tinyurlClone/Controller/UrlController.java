package com.urlshortnerproj.tinyurlClone.Controller;

import com.urlshortnerproj.tinyurlClone.DTO.UrlRequestDTO;
import com.urlshortnerproj.tinyurlClone.DTO.UrlResponseDTO;
import com.urlshortnerproj.tinyurlClone.Service.UrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

@Controller
public class UrlController {
    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponseDTO> shorten(@RequestBody UrlRequestDTO request) {
        return ResponseEntity.ok(service.shorten(request));
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        return ResponseEntity.status(302)
                .location(URI.create(service.getOriginal(code)))
                .build();
    }

    @GetMapping("/{code}/qr")
    public ResponseEntity<byte[]> downloadQr(@PathVariable String code) {

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"qr-" + code + ".png\"")
                .contentType(MediaType.IMAGE_PNG)
                .body(service.getQr(code));
    }
}
