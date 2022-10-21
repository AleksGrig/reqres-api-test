package org.wightwalker;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PatchTest extends BaseTest {

  @Test
  public void patchTest() {
    String patch = """
      {
        "name":"august",
        "job":"emperor"
      }""";
    given()
      .body(patch)
      .pathParam("id", 2)
    .when()
      .patch(Paths.UPDATE_USER)
    .then()
      .log().all()
      .assertThat().statusCode(200)
      .body("updatedAt", Matchers.notNullValue());
  }
}
