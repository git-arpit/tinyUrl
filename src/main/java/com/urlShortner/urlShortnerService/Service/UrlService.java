package com.urlShortner.urlShortnerService.Service;

import com.urlShortner.urlShortnerService.Model.UrlDto;
import com.urlShortner.urlShortnerService.Model.UrlModel;
import com.urlShortner.urlShortnerService.Model.UrlResponse;
import org.springframework.stereotype.Service;

@Service
public interface UrlService {

    public UrlResponse generateShortUrl(UrlDto urlDto);
    public UrlModel persistUrl(UrlModel urlModel);
    public void deleteUrl(UrlModel urlModel);

    public UrlModel getEncodedUrl(String shortUrl);



}
