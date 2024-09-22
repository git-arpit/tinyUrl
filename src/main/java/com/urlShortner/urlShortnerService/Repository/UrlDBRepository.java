package com.urlShortner.urlShortnerService.Repository;

import com.urlShortner.urlShortnerService.Model.UrlDto;
import com.urlShortner.urlShortnerService.Model.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlDBRepository extends JpaRepository<UrlModel, String> {

    public UrlModel findByShortUrl(String shortUrl);
}
