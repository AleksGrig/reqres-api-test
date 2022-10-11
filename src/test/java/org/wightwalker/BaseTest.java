package org.wightwalker;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseTest {
  @BeforeSuite
  public void setup() {
    System.out.println("BeforeSuite: setup method");
    RestAssured.baseURI = "https://reqres.in/api/users";
  }

  @AfterSuite
  public void teardown() {
    System.out.println("AfterSuite: teardown method");
  }
}
