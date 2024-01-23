package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class Test200 {

//    public class User(){
//        private int id;
//        private char email;
//        private char firstname;
//        private char lastname;
//        private char avatar;
//    }

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
    public void test(){

        test200();
        test200("id",  2);
        test200("email",  "janet.weaver@reqres.in");
        test200("first_name",  "suss");
        test200("last_name",  "sussu");
        test200("avatar",  "susus");

    }

}
