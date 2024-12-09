package com.outsera.qa.payloads;

import com.google.gson.Gson;
import com.outsera.qa.model.ProdutosModel;
import com.outsera.qa.utils.Utils;


public class ProdutosPayload {

    public static String toJson(){
        ProdutosModel produtos = new ProdutosModel(Utils.faker.commerce().productName(), 50, Utils.faker.lorem().sentence(5), 3);
        return new Gson().toJson(produtos);
    }

}
