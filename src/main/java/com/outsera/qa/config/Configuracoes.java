package com.outsera.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({"file:src/main/resources/application.properties"})
public interface Configuracoes extends Config {

    @Key("environment")
     String environment();

    @Key("baseUrls.dev")
    String baseUrlDev();

    @Key("baseUrls.hml")
      String baseUrlHml();

    @Key("baseUrls.prd")
     String baseUrlPrd();

    enum Environment {
        DEV, HML, PRD
    }

}



