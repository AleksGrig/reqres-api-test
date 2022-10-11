package org.wightwalker;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PatchTest extends BaseTest {

  @Test
  public void patchTest() {
    RestAssured.basePath = "2";
    String userData = """
      {
        "name":"august",
        "job":"emperor"
      }
      """;
    RestAssured.given().body(userData)
      .patch()
      .then().log().all()
      .assertThat().statusCode(200)
      .body("updatedAt", Matchers.notNullValue());
  }
}
