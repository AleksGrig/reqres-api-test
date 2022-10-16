package org.wightwalker;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostTest extends BaseTest {
  
  @Test
  public void postTest() {
    String userData = """
      {
        "name":"morpheus",
        "job":"leader"
      }
      """;
    RestAssured.given().body(userData)
      .when().post()
      .then().log().all()
      .assertThat().statusCode(201)
      .body("id", Matchers.notNullValue());
  }
}
