package org.wightwalker;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetTest extends BaseTest {

  @Test
  public void getPage1Test() {
    RestAssured.given()
      .log().all()
      .get()
      .then().assertThat()
      .statusCode(200)
      .body("page", Matchers.equalTo(1));
  }

  @Test
  public void getPage2Test() {
    RestAssured.given()
      .queryParams("page", "2")
      .body("")
      .log().all()
      .when().get()
      .then().assertThat()
      .statusCode(200)
      .body("page", Matchers.equalTo(2));
  }
}
