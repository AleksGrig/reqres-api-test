package org.wightwalker;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;

@Test
public class LoginTest extends BaseTest {
  
  public void successfulLoginTest() {
    String credentials = "{\"email\":\"eve.holt@reqres.in\",\"password\":\"cityslicka\"}";

    given()
      .contentType(ContentType.JSON)
      .body(credentials)
    .when()
      .post(Paths.LOGIN)
    .then()
      .log().all()
      .statusCode(200)
      .body("token", Matchers.notNullValue());
  }
  
  public void unsuccessfulLoginTest() {
    String credentials = "{\"email\": \"peter@klaven\"}";

    given()
      .contentType(ContentType.JSON)
      .body(credentials)
    .when()
      .post(Paths.LOGIN)
    .then()
      .log().all()
      .statusCode(400)
      .body("error", Matchers.equalTo("Missing password"));
  }
}
