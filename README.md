
## Spring Boot 2.0 Will Feature Improved Actuator Endpoints 

### InfoQ Java Queue

#### published August xx, 2017

This example application was adapted from Stéphane Nicoll's actuator [example](https://github.com/snicoll-scratches/webmvc-actuator) and demonstrates how to create a user-defined endpoint. 

##### Application Build and Execution with Maven

The application can be built with [Maven](http://maven.apache.org/) by issuing the following commands:

`mvn clean package`

`java -jar target/actuator-0.0.1.jar`

##### Application Build and Execution with Gradle

The application can be built with [Gradle](https://gradle.org/) by issuing the following commands:

`gradle clean build`

`java -jar build/libs/actuator-0.0.1.jar`

Once running, open your browser:

`localhost:8080/application` will display all the endpoints.

`localhost:8080/application/person` will display all the names from the user-defined endpoint.

`localhost:8080/application/person/mike` will display only my name.

Please don't hesitate to contact me at [mike@redlich.net](mailto:mike@redlich.net) with any questions.
