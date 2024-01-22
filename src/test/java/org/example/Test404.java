package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test404 {

    @Test
    public void test404() {

        RestAssured
                .given()
                    .baseUri("https://reqres.in")
                .when()
                    .log().all()
                    .get("/api/users/{id}", 23)
                .then()
                    .log().all()
                    .statusCode(404);

    }

}
