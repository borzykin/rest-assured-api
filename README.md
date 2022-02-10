# rest-assured-api framework

Requisites: Java 11, Maven

- RestAssured for API calls
- Lombok to get rid of boilerplate
- TestNG to handle parallelism
- Allure reports with full request and response logging
- Owner for properties configuration

To run tests: `mvn clean test -Denv=dev`
To build report: `allure serve` given you in /target folder and allure CLI is installed and in the path
