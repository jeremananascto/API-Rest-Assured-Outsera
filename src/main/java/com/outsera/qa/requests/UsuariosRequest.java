package com.outsera.qa.requests;

import com.outsera.qa.interfaces.EndpointsServerest;
import com.outsera.qa.payloads.UsuariosPayload;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import static com.outsera.qa.interfaces.EndpointsServerest.PATH_USUARIOS;
import static com.outsera.qa.utils.LogUtils.logResponse;
import static io.restassured.RestAssured.given;

@Slf4j
public class UsuariosRequest {



    @Step("Listar usuários cadastrados")
    public Response listar() {
        log.info("Enviando requisição GET para endpoint: {}", PATH_USUARIOS);

        Response response = given()
                .when()
                .get(PATH_USUARIOS);

        logResponse(response);  // Loga a resposta
        return response;
    }

    @Step("Listar usuários cadastrados com filtro")
    public Response listar(String queryParam, String valueParam) {
        log.info("Enviando requisição GET para endpoint: {} com queryParam: {} e valueParam: {}", PATH_USUARIOS, queryParam, valueParam);

        Response response = given()
                .when()
                .queryParam(queryParam, valueParam)
                .get(PATH_USUARIOS);

        logResponse(response);  // Loga a resposta
        return response;
    }

    @Step("Buscar usuário por ID")
    public Response buscarPorId(String id) {
        log.info("Enviando requisição GET para endpoint: {} com ID: {}", PATH_USUARIOS, id);

        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .pathParam("_id", id)
                .get(PATH_USUARIOS + "/{_id}");

        logResponse(response);  // Loga a resposta
        return response;
    }

    @Step("Cadastrar usuário com administrador")
    public Response cadastrar(boolean administrador) {
        log.info("Enviando requisição POST para endpoint: {} para cadastrar usuário com administrador: {}", PATH_USUARIOS, administrador);

        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .body(UsuariosPayload.toJson(administrador))
                .post(PATH_USUARIOS);

        logResponse(response);  // Loga a resposta
        return response;
    }

    @Step("Cadastrar usuário com dados completos")
    public Response cadastrar(String nome, String email, String password, boolean administrador) {
        log.info("Enviando requisição POST para endpoint: {} para cadastrar usuário com nome: {}, email: {}", PATH_USUARIOS, nome, email);

        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .body(UsuariosPayload.toJson(nome, email, password, administrador))
                .post(PATH_USUARIOS);

        logResponse(response);  // Loga a resposta
        return response;
    }

    @Step("Excluir usuário")
    public Response excluir(String id) {
        log.info("Enviando requisição DELETE para endpoint: {} para excluir usuário com ID: {}", PATH_USUARIOS, id);

        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .pathParam("_id", id)
                .delete(PATH_USUARIOS + "/{_id}");

        logResponse(response);  // Loga a resposta
        return response;
    }

    @Step("Alterar usuário")
    public Response alterar(String nome, String email, String password, boolean administrador, String id) {
        log.info("Enviando requisição PUT para endpoint: {} para alterar usuário com ID: {}", PATH_USUARIOS, id);

        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .body(UsuariosPayload.toJson(nome, email, password, administrador))
                .pathParam("_id", id)
                .put(PATH_USUARIOS + "/{_id}");

        logResponse(response);  // Loga a resposta
        return response;
    }

    @Step("Buscar ID do primeiro usuário")
    public String getIdPrimeiroUsuario() {
        log.info("Buscando ID do primeiro usuário...");

        Response response = listar();
        String usuarioId = response.then().statusCode(HttpStatus.SC_OK).extract().path("usuarios[0]._id");

        log.info("ID do primeiro usuário encontrado: {}", usuarioId);
        return usuarioId;
    }
}
