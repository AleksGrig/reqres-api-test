package org.wightwalker;

import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostTest extends BaseTest {
  
  @Test
  public void postTest() {
    RestAssured.basePath = Paths.CREATE_USER;
    User user = new User("user@users.com", "User", 
                         "Userov", "https://reqres.in/img/faces/1-image.jpg");
    RestAssured.given().body(user)
      .when().post()
      .then().log().all()
      .assertThat().statusCode(201)
      .body("id", Is.is(Matchers.notNullValue()));
  }
}
