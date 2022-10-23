package org.wightwalker;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

@Test
public class DeleteTest extends BaseTest{
  
  public void deleteUserTest() {
    given()
      .pathParam("id", 3)
    .when()
      .delete(Paths.DELETE_USER)
    .then()
      .log().all()
      .statusCode(204);
  }
}
