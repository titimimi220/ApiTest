package org.example;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Test404 {
    private final static String URL = "https://reqres.in/api/users/";
    @Test
    public void test404() {

        List<MainClass> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "api/users/23")
                .then().log().all()
                .extract().body().jsonPath().getList("data", MainClass.class);

    }

}
