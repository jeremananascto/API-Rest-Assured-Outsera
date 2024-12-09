package com.outsera.qa.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Utils {

    public static Faker faker = new Faker(new Locale("pt-BR"));

    private static String environment;
    private static String baseUrl;

    /**
     * Define o ambiente para configuração do URL base.
     *
     * @param env Ambiente (dev, hml, prd)
     */
    public static void setEnvironment(String env) {
        environment = env.toLowerCase();
        updateBaseUrl();
    }

    /**
     * Obtém o URL base do ambiente configurado.
     *
     * @return URL base do ambiente configurado.
     * @throws IllegalStateException Se o ambiente não foi configurado.
     */
    public static String getBaseUrl() {
        if (baseUrl == null) {
            throw new IllegalStateException("O ambiente não foi configurado. Chame setEnvironment antes de getBaseUrl.");
        }
        return baseUrl;
    }

    private static void updateBaseUrl() {
        switch (environment) {
            case "dev":
                baseUrl = "https://serverest.dev";
                break;
            case "hml":
                baseUrl = "https://serverest.dev";
                break;
            case "prd":
                baseUrl = "https://serverest.dev";
                break;
            default:
                throw new IllegalArgumentException("Ambiente não suportado: " + environment);
        }
    }
}



