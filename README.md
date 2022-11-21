# *reqres-api-test*
## *Rest Assured API Testing Maven Framework* based on [Automation Step by Step youtube course](https://www.youtube.com/watch?v=oVNbaBlrhbo&list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx&index=1)
## [Reqres - a hosted REST-API](https://reqres.in/)

`git clone https://github.com/AleksGrig/reqres-api-test.git`

### run tests and generating allure report
```
mvn clean test
allure serve
```

## *Libraries*
- rest-assured - library for testing and validating REST services in Java
- testng - testing framework for Java
- jackson-databind - mapping functionality that allows reading JSON content into Java objects and vice versa
- async-http-client - library that allows Java applications to easily execute HTTP requests and asynchronously process HTTP responses
- json-schema-validator - a fast Java JSON schema validator
- allure-testng - a test report tool

## *Folder Structure*
- resources - property file
- src
  - main/java/org/wightwalker - helper classes
  - resources - schema validator
  - test/java/org/wightwalker - all framework tests
- pom.xml
- testng.xml