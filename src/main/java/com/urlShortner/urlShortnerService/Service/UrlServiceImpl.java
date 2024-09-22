package com.urlShortner.urlShortnerService.Service;

import com.urlShortner.urlShortnerService.Constraints.ApplicationConstraints;
import com.urlShortner.urlShortnerService.Model.UrlDto;
import com.urlShortner.urlShortnerService.Model.UrlModel;
import com.urlShortner.urlShortnerService.Model.UrlResponse;
import com.urlShortner.urlShortnerService.Repository.UrlDBRepository;
import com.urlShortner.urlShortnerService.Utils.UrlUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class UrlServiceImpl implements UrlService{
    @Autowired
    UrlUtilities urlUtils;
    @Autowired
    UrlDBRepository urlRepo;

    @Autowired
    UrlResponse urlResponse;


    @Override
    public UrlResponse generateShortUrl(UrlDto urlDto) {
        if(urlDto.getOriginalUrl().isEmpty()){
        return null;}
        String encodedUrl = urlUtils.encode(urlDto.getOriginalUrl());
        UrlModel urlModel = new UrlModel();
        if(urlUtils.isValidityBlank(urlDto)){
            urlModel.setExpiryTime(LocalDateTime.now().plusSeconds(ApplicationConstraints.DEFAULTEXP));
        }
        else {
            urlModel.setExpiryTime(LocalDateTime.now().plusSeconds(urlDto.getValidity()));
        }
        urlModel.setOriginalUrl(urlDto.getOriginalUrl());
        urlModel.setShortUrl(encodedUrl);
        persistUrl(urlModel);
        urlResponse.setOriginalUrl(urlModel.getOriginalUrl());
        urlResponse.setShortUrl(urlModel.getShortUrl());
        urlResponse.setExpiryTime(urlModel.getExpiryTime());
        return  urlResponse;
    }

    @Override
    public UrlModel persistUrl(UrlModel urlModel) {
        return urlRepo.save(urlModel);
            }

    @Override
    public void deleteUrl(UrlModel urlModel) {
        urlRepo.delete(urlModel);

    }

    @Override
    public UrlModel getEncodedUrl(String shortUrl) {
        UrlModel shortUrlModel = urlRepo.findByShortUrl(shortUrl);
        return  shortUrlModel;
    }

}
