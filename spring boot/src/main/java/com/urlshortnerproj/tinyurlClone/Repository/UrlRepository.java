package com.urlshortnerproj.tinyurlClone.Repository;

import com.urlshortnerproj.tinyurlClone.Entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlMapping,Long> {
    Optional<UrlMapping> findByShortUrl(String shortUrl);
}
