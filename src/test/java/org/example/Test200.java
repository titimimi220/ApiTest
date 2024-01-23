package org.example;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertAll;


public class Test200 {

    ValidatableResponse var;
    public void test200(String pun, String val) {
        var.body(("data." + pun), equalTo(val));
    }

    public void test200(String pun, int val) {
        var.body(("data." + pun), equalTo(val));
    }

    public void test200(String pun) {
        var.body(("data." + pun), not(equalTo(null)));
    }
    @BeforeClass
    public void test200() {

       var = RestAssured
                .given()
                    .baseUri("https://reqres.in")
                .when()
                    .log().all()
                    .get("/api/users/{id}", 2)
                .then()
                    .log().all()
                    .statusCode(200);


    }


    @Test
    public void test1(){
        test200();

    }
    @Test
    public void test2(){

        assertAll("тесты:",
                ()->  test200("id",  2),
                ()-> test200("email",  "janet.weaver@reqres.in"),
                ()-> test200("first_name",  "suss"),
                ()-> test200("last_name",  "sussu"),
                ()-> test200("avatar",  "susus"));


    }

    @Test
    public void test3(){

        assertAll("тесты:",
                ()->  test200("id"),
                ()-> test200("email"),
                ()-> test200("first_name"),
                ()-> test200("last_name"),
                ()-> test200("avatar"));


    }

}

