package com.outsera.qa.requests;

import com.outsera.qa.interfaces.EndpointsServerest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import static com.outsera.qa.interfaces.EndpointsServerest.PATH_PRODUTOS;
import static com.outsera.qa.utils.LogUtils.logResponse;
import static io.restassured.RestAssured.given;

@Slf4j
public class ProdutosRequest {



    @Step("Listar produtos cadastrados")
    public Response listar() {
        log.info("Enviando requisição GET para endpoint: {}", PATH_PRODUTOS);

        Response response = given()
                .when()
                .get(PATH_PRODUTOS);

        logResponse(response);  // Loga a resposta
        return response;
    }

    @Step("Buscar produtos por ID")
    public Response buscarPorId(String id) {
        log.info("Enviando requisição GET para endpoint: {} com ID: {}", PATH_PRODUTOS, id);

        Response response = given()
                .when()
                .pathParam("_id", id)
                .get(PATH_PRODUTOS + "/{_id}");

        logResponse(response);  // Loga a resposta
        return response;
    }

    @Step("Buscar ID do primeiro usuário.")
    public String buscarIdPrimeiroUsuario() {
        log.info("Buscando ID do primeiro produto...");

        Response response = this.listar();
        String produtoId = response.then().statusCode(HttpStatus.SC_OK).extract().path("produtos[0]._id");

        log.info("ID do primeiro produto encontrado: {}", produtoId);
        return produtoId;
    }
}
