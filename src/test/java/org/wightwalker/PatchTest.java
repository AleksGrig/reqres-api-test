package org.wightwalker;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PatchTest extends BaseTest {

  @Test
  public void patchTest() {
    String userData = """
      {
        "name":"august",
        "job":"emperor"
      }
      """;
    RestAssured.given().body(userData)
      .patch(Paths.UPDATE_USER.replace("{id}", "2"))
      .then().log().all()
      .assertThat().statusCode(200)
      .body("updatedAt", Matchers.notNullValue());
  }
}
