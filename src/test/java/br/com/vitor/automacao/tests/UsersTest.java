package br.com.vitor.automacao.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

import br.com.vitor.automacao.core.BaseTest;

public class UsersTest extends BaseTest{

    @Test
    public void shouldListUsers(){
        given()
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .body("page", is(1))
            .body("data", is(not(empty())))
            .body("data.first_name", hasItem("George"))
        ;
    }

    @Test
    public void shouldCreateUserSuccessfully(){
        String requestBody = "{\"name\": \"Vitor\", \"job\": \"QA Engineer\"}";

        given()
            .body(requestBody)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("name", is("Vitor"))
            .body("job", is("QA Engineer"))
            .body("id", is(notNullValue()))
            .body("createdAt", is(notNullValue()))
        ;
    }

    @Test
    public void shouldUpdateUserSuccessfully(){
        String requestBody = "{\"name\": \"Vitor - Updated\", \"job\": \"Senior QA Engineer\"}";

        given()
            .pathParam("userId", 2)
            .body(requestBody)
        .when()
            .put("/users/{userId}")
        .then()
            .statusCode(200)
            .body("name", is("Vitor - Updated"))
            .body("job", is("Senior QA Engineer"))
            .body("updatedAt", is(notNullValue()))
        ;
    }

    @Test
    public void shouldDeleteUserSuccessfully(){
        given()
            .pathParam("userId",2)
        .when()
            .delete("/users/{userId}")
        .then()
            .statusCode(204)
        ;
    }
}
