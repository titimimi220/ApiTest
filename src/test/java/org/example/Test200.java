package org.example;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Test200 {
    private final static String URL = "https://reqres.in/api/users/";

    @Test
    public void test200() {

        List<MainClass> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", MainClass.class);

    }

}
