package org.wightwalker;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetTest extends BaseTest {

  @Test
  public void getPage1Test() {
    RestAssured.given()
      .when().get(Paths.ALL_USERS)
      .then().log().all()
      .assertThat().statusCode(200)
      .body("page", Matchers.equalTo(1));
  }

  @Test
  public void getPage2Test() {
    RestAssured.given()
      .queryParams("page", "2")
      .body("")
      .when().get(Paths.ALL_USERS)
      .then().log().all()
      .assertThat().statusCode(200)
      .body("page", Matchers.equalTo(2));
  }

  @Test
  public void getUser() {
    RestAssured.given()
      .pathParam("id", 2)
      .when().get(Paths.USER)
      .then().log().all()
      .assertThat().statusCode(200)
      .body("data.email", Matchers.equalTo("janet.weaver@reqres.in"));
  }
}
