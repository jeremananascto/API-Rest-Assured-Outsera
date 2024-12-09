package com.outsera.qa.requests;

import com.outsera.qa.filters.HeaderFilter;
import com.outsera.qa.interfaces.EndpointsServerest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static com.outsera.qa.interfaces.EndpointsServerest.PATH_CARRINHOS;
import static com.outsera.qa.utils.LogUtils.logResponse;
import static io.restassured.RestAssured.given;

@Slf4j
public class CarrinhosRequest {



    @Step("Listar todos os carrinhos cadastrados.")
    public Response listar() {
        log.info("Enviando requisição GET para endpoint: {}", PATH_CARRINHOS);

        Response response = given()
                .when()
                .get(PATH_CARRINHOS);

        logResponse(response);  // Loga a resposta
        return response;
    }
}