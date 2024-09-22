package com.urlShortner.urlShortnerService.Model;

import org.springframework.stereotype.Component;

public class UrlErrorResponse {
    String statusCode;
    String errorMessage;

    public UrlErrorResponse() {

    }

    public UrlErrorResponse(String statusCode, String errorMessage) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "UrlErrorResponse{" +
                "statusCode='" + statusCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
