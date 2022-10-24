package org.wightwalker;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

@Test
public class PutTest {
  
  public void putTest() {
    User user = new User("newuser@users.com", "NewUser",
                         "Newuserov", "https://reqres.in/img/faces/2-image.jpg");

    given()
      .contentType(ContentType.JSON)
      .pathParam("id", 2)
      .body(user)
    .when()
      .put(Paths.UPDATE_USER)
    .then()
      .log().all()
      .statusCode(200)
      .body("updatedAt", Matchers.notNullValue());  
  }
}
