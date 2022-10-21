package org.wightwalker;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Test
public class SchemaTest {
  
  public void schemaValidationTest() {
    given()
    .when()
      .get(Paths.ALL_USERS)
    .then()
      .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
      .statusCode(200);
  }
}
