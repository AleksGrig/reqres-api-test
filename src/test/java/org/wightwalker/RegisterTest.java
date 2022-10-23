package org.wightwalker;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;

@Test
public class RegisterTest extends BaseTest {
  
  public void successfulRegisterTest() {
    String credentials = "{\"email\":\"eve.holt@reqres.in\",\"password\":\"pistol\"}";
    
      given()
        .contentType(ContentType.JSON)
        .body(credentials)
      .when()
        .post(Paths.REGISTER)
      .then()
        .log().all()
      .statusCode(200)
      .body("id", Matchers.notNullValue());
  }
  
  public void unsuccessfulRegisterTest() {
    String credentials = "{\"email\":\"eve.holt@reqres.in\"}";

      given()
        .contentType(ContentType.JSON)
        .body(credentials)
      .when()
        .post(Paths.REGISTER)
      .then()
        .log().all()
      .statusCode(400)
      .body("error", Matchers.equalTo("Missing password"));
  }
}
