package com.outsera.qa.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;


public class HeaderFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext context) {
        // Adiciona os headers comuns
        requestSpec
                .header("accept", "application/json")
                .header("Content-Type", "application/json");

        // Continua o fluxo, passando para a próxima etapa do processo
        return context.next(requestSpec, responseSpec);
    }
}
