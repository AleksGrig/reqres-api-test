package org.wightwalker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseTest {
  @BeforeSuite
  public void setup() {
    System.out.println("BeforeSuite: setup method");
    Properties properties = new Properties();
    try {
      properties.load(new FileInputStream("resources/source.properties"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestAssured.baseURI = properties.getProperty("baseURI");
  }

  @AfterSuite
  public void teardown() {
    System.out.println("AfterSuite: teardown method");
  }
}
