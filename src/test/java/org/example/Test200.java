package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;


public class Test200 {

    @Test
    public void test200() {

        RestAssured
                .given()
                    .baseUri("https://reqres.in")
                .when()
                    .log().all()
                    .get("/api/users/{id}", 2)
                .then()
                    .log().all()
                    .statusCode(200);


    }

}