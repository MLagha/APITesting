package com.sparta.ml;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class RestAssuredTests {

    @Test
    @DisplayName("Check status code of website")
    void CheckStatusCodeOfWebsite() {
        get("http://www.spartaglobal.com")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    @DisplayName("Check the server software for the website")
    void CheckTheServerSoftwareForTheWebsite() {
        given()
                .response()
                .when()
                .get("http://www.spartaglobal.com")
                .getHeader("X-Powered-By")
                .equals("ASP.NET");
    }


}
