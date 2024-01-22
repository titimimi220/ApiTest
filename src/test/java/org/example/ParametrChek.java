package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParametrChek {

   @Test
    public void ParametrChekTest() {

       RestAssured
               .given()
                    .baseUri("https://reqres.in")
               .when()
                    .log().all()
                    .get("/api/users/{id}", 2)
               .then()
                    .log().all()
                    .statusCode(200)
                    .body("data.id", equalTo(2))
                    .body("data.email", equalTo("janet.weaver@reqres.in"))
                    .body("data.first_name", equalTo("Janet"))
                    .body("data.last_name", equalTo("Weaver"))
                    .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));


   }

}
