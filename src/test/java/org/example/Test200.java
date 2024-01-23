package org.example;

import io.restassured.RestAssured;
import junit.framework.Assert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.function.Executable;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertAll;


public class Test200 {

    public void test200(String pun, String val) {

        RestAssured
                .given()
                .baseUri("https://reqres.in")
                .when()
                .log().all()
                .get("/api/users/{id}", 2)
                .then()
                .log().all()
                .body(("data." + pun), equalTo(val));
    }

    public void test200(String pun, int val) {

        RestAssured
                .given()
                .baseUri("https://reqres.in")
                .when()
                .log().all()
                .get("/api/users/{id}", 2)
                .then()
                .log().all()
                .body(("data." + pun), equalTo(val));
    }

    public void test200(String pun) {

        RestAssured
                .given()
                .baseUri("https://reqres.in")
                .when()
                .log().all()
                .get("/api/users/{id}", 2)
                .then()
                .log().all()
                .body(("data." + pun), not(equalTo(null)));
    }

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


    @Test
    public void test1(){
        test200();

    }
    @Test
    public void test2(){

        test200();
        assertAll("тесты:",
                ()->  test200("id",  2),
                ()-> test200("email",  "janet.weaver@reqres.in"),
                ()-> test200("first_name",  "suss"),
                ()-> test200("last_name",  "sussu"),
                ()-> test200("avatar",  "susus"));


    }

    @Test
    public void test3(){

        test200();
        assertAll("тесты:",
                ()->  test200("id"),
                ()-> test200("email"),
                ()-> test200("first_name"),
                ()-> test200("last_name"),
                ()-> test200("avatar"));


    }

}

