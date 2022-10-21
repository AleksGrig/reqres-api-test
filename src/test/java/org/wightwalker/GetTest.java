package org.wightwalker;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

@Test
public class GetTest extends BaseTest {

  public void getPage1Test() {
    given()
    .when()
      .get(Paths.ALL_USERS)
    .then()
      .log().all()
      .assertThat().statusCode(200)
      .body("page", Matchers.equalTo(1));
  }

  public void getPage2Test() {
    given()
      .queryParams("page", "2")
      .body("")
    .when()
      .get(Paths.ALL_USERS)
    .then()
      .log().all()
      .assertThat().statusCode(200)
      .body("page", Matchers.equalTo(2));
  }

  public void getUser() {
    given()
      .pathParam("id", 2)
    .when()
      .get(Paths.USER)
    .then()
      .log().all()
      .assertThat().statusCode(200)
      .body("data.email", Matchers.equalTo("janet.weaver@reqres.in"));
  }
}
