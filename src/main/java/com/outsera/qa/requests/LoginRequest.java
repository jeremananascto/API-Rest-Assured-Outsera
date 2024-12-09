package com.outsera.qa.requests;

import com.outsera.qa.payloads.LoginPayload;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import static com.outsera.qa.interfaces.EndpointsServerest.PATH_LOGIN;
import static com.outsera.qa.utils.LogUtils.logResponse;
import static io.restassured.RestAssured.given;

@Slf4j
public class LoginRequest {




    @Step("Realizar login - POST")
    public Response logar(String email,String password) {

        log.info("Enviando requisição POST para endpoint: {}", PATH_LOGIN);
        log.debug("Payload enviado: {}", LoginPayload.toJson(email,password));

        Response response = given()
                .when()
                .body(LoginPayload.toJson(email, password))
                .post(PATH_LOGIN);

        logResponse(response);
        return response;







    }

    @Step("Realizar login - GET")
    public Response getLogin(String email, String password) {
        log.info("Enviando requisição GET para endpoint: {}", PATH_LOGIN);
        log.debug("Payload enviado: {}", LoginPayload.toJson(email, password));

        Response response = given()
                .when()
                .body(LoginPayload.toJson(email, password))
                .get(PATH_LOGIN);

        logResponse(response);
        return response;
    }

    @Step("Realizar login - PUT")
    public Response putLogin(String email, String password) {
        log.info("Enviando requisição PUT para endpoint: {}", PATH_LOGIN);
        log.debug("Payload enviado: {}", LoginPayload.toJson(email, password));

        Response response = given()
                .when()
                .body(LoginPayload.toJson(email, password))
                .put(PATH_LOGIN);

        logResponse(response);
        return response;
    }

    @Step("Realizar login - DELETE")
    public Response deleteLogin(String email, String password) {
        log.info("Enviando requisição DELETE para endpoint: {}", PATH_LOGIN);
        log.debug("Payload enviado: {}", LoginPayload.toJson(email, password));

        Response response = given()
                .when()
                .body(LoginPayload.toJson(email, password))
                .delete(PATH_LOGIN);
        logResponse(response);
        return response;
    }

    public String getBearerToken(String email, String password) {
        log.info("Obtendo Bearer Token para o usuário: {}", email);
        Response response = logar(email, password);
        if (response.statusCode() == HttpStatus.SC_OK) {
            String token = response.then().extract().path("authorization");
            log.info("Bearer Token obtido com sucesso.");
            return token;
        } else {
            log.error("Falha ao obter o Bearer Token. Status: {}, Resposta: {}", response.statusCode(), response.body().asString());
            throw new RuntimeException("Não foi possível obter o Bearer Token.");
        }
    }


}
