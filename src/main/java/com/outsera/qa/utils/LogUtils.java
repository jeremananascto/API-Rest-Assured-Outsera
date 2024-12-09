package com.outsera.qa.utils;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class LogUtils {

    public static void logResponse(Response response) {
        log.info("Resposta recebida: Status - {}", response.statusCode());
        log.debug("Resposta completa: {}", response.body().asString());
    }





}
