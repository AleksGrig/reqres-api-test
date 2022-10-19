package org.wightwalker;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PatchTest extends BaseTest {

  @Test
  public void patchTest() {
    RestAssured.given()
      .body("""
      {
        "name":"august",
        "job":"emperor"
      }""")
      .pathParam("id", 2)
      .patch(Paths.UPDATE_USER)
      .then().log().all()
      .assertThat().statusCode(200)
      .body("updatedAt", Matchers.notNullValue());
  }
}
