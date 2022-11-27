
# tramites-backend

Application in [Spring Boot](http://projects.spring.io/spring-boot/) of requests for claims and complaints for the University of Cauca, CO.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.unicauca.tramites.TramitesApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Running using `Dockerfile`

The Dockerfile template creates a Docker image for your application that:

* Use the `maven:3.6.0-jdk-8-slim` and `openjdk:8` images

The template also makes the following assumptions about your application:

* It timezone is ` America/Bogota`

You can change these settings by updating the Dockerfile.

### Building the Docker image for your application

After any required changes have been made to the Dockerfile, you can build a Docker image for your application using the following command:

```sh
docker build -t  tramites-backend .
```
where tramites-backend` is the name you want to give your created Docker image.

### Running the Docker image for your application
You can run it using either of the following commands:

* Run as an interactive application on your command line:
  ```sh
  docker run -i -p 8080:8080 -t tramites-backend
  ```
  This maps port 8080 in the Docker image to port 8080 on your machine. If you are using a different port, you will need to change the mapping.

* Run as a daemon process:
  ```sh
  docker run -d -p 8080:8080 -t tramites-backend
  ```
  This uses the `-d` flag rather than the `-i` flag to run the Docker image as a background task.

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/alirocorrea/tramites-backend/blob/main/LICENSE) file.
