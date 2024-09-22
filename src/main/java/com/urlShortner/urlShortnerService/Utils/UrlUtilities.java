package com.urlShortner.urlShortnerService.Utils;

import com.google.common.hash.Hashing;
import com.urlShortner.urlShortnerService.Constraints.ApplicationConstraints;
import com.urlShortner.urlShortnerService.Model.UrlDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
@Component
public class UrlUtilities {

    public String encode(String originalUrl) {

        String localDateTime = LocalDateTime.now().toString();
        String toEncode = originalUrl.concat(localDateTime);
        return Hashing.murmur3_32_fixed().hashString(toEncode, StandardCharsets.UTF_8).toString();
    }


    public boolean isValidityBlank(UrlDto urlDto) {
        return urlDto.getValidity() == 0;
    }

    public boolean isNull(String str) {
        return str == null || str.equalsIgnoreCase(ApplicationConstraints.EMPTY);
    }

}
