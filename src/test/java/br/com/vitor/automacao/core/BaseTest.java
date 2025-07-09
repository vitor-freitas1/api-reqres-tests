package br.com.vitor.automacao.core;

import org.junit.jupiter.api.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;


public class BaseTest {

    @BeforeAll
    public static void setup(){
    // Configuração base da URL da API
    RestAssured.baseURI = "https://reqres.in";
    RestAssured.basePath = "/api";

    // Configuração de um Request Builder padrão que será usado em todos os testes
    RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
    reqBuilder.setContentType("application/json");
    reqBuilder.addHeader("x-api-key", "reqres-free-v1");
    RestAssured.requestSpecification = reqBuilder.build();

    // Configuração de um Response Builder padrão que será usado em todos os testes
    ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
    resBuilder.expectResponseTime(Matchers.lessThan(5000L));
    RestAssured.responseSpecification = resBuilder.build();

    // Habilita logs caso alguma validação falhe, muito útil para depuração
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
