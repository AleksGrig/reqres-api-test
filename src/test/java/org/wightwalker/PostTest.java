package org.wightwalker;

import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PostTest extends BaseTest {
  
  @Test
  public void postTest() {
    User user = new User("user@users.com", "User", 
                         "Userov", "https://reqres.in/img/faces/1-image.jpg");
    given()
      .body(user)
    .when()
      .post(Paths.CREATE_USER)
    .then()
      .log().all()
      .assertThat().statusCode(201)
      .body("id", Is.is(Matchers.notNullValue()));
  }
}
