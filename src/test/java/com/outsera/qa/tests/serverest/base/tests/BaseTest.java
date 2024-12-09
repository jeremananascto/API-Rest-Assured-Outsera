package com.outsera.qa.tests.serverest.base.tests;



import com.outsera.qa.config.Configuracoes;
import com.outsera.qa.filters.HeaderFilter;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Slf4j
public class BaseTest  {




   private static final Logger customLog = LoggerFactory.getLogger(RestAssuredConfig.class);
    private static final Configuracoes config = ConfigFactory.create(Configuracoes.class);

    @BeforeAll
    public static void setUp() {
        // Obter o ambiente
        String environmentKey = config.environment();
        Configuracoes.Environment environment = Configuracoes.Environment.valueOf(environmentKey.toUpperCase());

        // Configurar o RestAssured
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = getBaseUrl(environment);
        RestAssured.filters(new HeaderFilter());

        log.info("Iniciando testes de API no ambiente: {}", environment);
    }

    private static String getBaseUrl(Configuracoes.Environment environment) {
        switch (environment) {
            case DEV:
                return config.baseUrlDev();
            case HML:
                return config.baseUrlHml();
            case PRD:
                return config.baseUrlPrd();
            default:
                throw new IllegalArgumentException("Ambiente inválido: " + environment);
        }



    }
}