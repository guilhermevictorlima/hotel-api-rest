package com.github.guilhermevictorlima.hotelapi.config.exception.handler;

import org.springframework.http.HttpStatusCode;

import java.util.List;

public record ApiErrorResponse(
        HttpStatusCode status,
        List<String> errors
) {}
