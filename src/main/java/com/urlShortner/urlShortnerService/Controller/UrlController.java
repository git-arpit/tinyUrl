package com.urlShortner.urlShortnerService.Controller;

import com.urlShortner.urlShortnerService.Model.UrlDto;
import com.urlShortner.urlShortnerService.Model.UrlErrorResponse;
import com.urlShortner.urlShortnerService.Model.UrlModel;
import com.urlShortner.urlShortnerService.Model.UrlResponse;
import com.urlShortner.urlShortnerService.Service.UrlService;
import com.urlShortner.urlShortnerService.Utils.UrlUtilities;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
public class UrlController {
    @Autowired
    private UrlService urlService;

    @Autowired
    UrlUtilities urlUtilities;



    @GetMapping("/h")
    public String getHealth(){
        return "OK";
    }

    @PostMapping("/create")
    public ResponseEntity<?> generateEncodedUrl(@RequestBody UrlDto urlDto){
        UrlResponse urlResponse = urlService.generateShortUrl(urlDto);
        if(urlResponse != null){
            return new ResponseEntity<UrlResponse>(urlResponse, HttpStatus.OK);
        }
        UrlErrorResponse urlErrorResponse = new UrlErrorResponse();
        urlErrorResponse.setErrorMessage("Service Error");
        urlErrorResponse.setStatusCode("502");
        return new ResponseEntity<>(urlErrorResponse,HttpStatus.BAD_GATEWAY) ;
    }


    @GetMapping("/{shortLink}")
    public ResponseEntity<?> redirectToUrl(@PathVariable("shortLink") String shortUrl, HttpServletResponse response) throws IOException {
        if (urlUtilities.isNull(shortUrl)) {
            UrlErrorResponse urlErrorResponse = new UrlErrorResponse();
            urlErrorResponse.setErrorMessage("Invalid or empty Url");
            urlErrorResponse.setStatusCode("200");
            return new ResponseEntity<>(urlErrorResponse,HttpStatus.OK);
        }
        UrlModel savedUrlModel = urlService.getEncodedUrl(shortUrl);

        if(savedUrlModel.getExpiryTime().isBefore(LocalDateTime.now())){
           urlService.deleteUrl(savedUrlModel);
            UrlErrorResponse urlErrorResponse = new UrlErrorResponse();
            urlErrorResponse.setErrorMessage("Expired encoded url - try generating a new one");
            urlErrorResponse.setStatusCode("200");
            return new ResponseEntity<>(urlErrorResponse,HttpStatus.OK);
        }else {

            String originalUrl = urlService.getEncodedUrl(shortUrl).getOriginalUrl();
            response.sendRedirect(originalUrl);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

}
