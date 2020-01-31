# Places Manager
This project was created to satisfy click-bus back-end challenge requirements.

Its purpose is to make possible the management of places. With that you will be able to create, update, find places by id and name
and also get all places at once.

### Tools

This project is developed using the following technologies:
- **Java;**
- **Spring Boot;**
- **Spring Data** for DB access;
- **MySQL** as database;
- **JUnit4**, **Mockito** and **MockMVC** for tests;
- **Swagger** for API Documentation;
- **Docker** for Project container building

## Package Structure

```
Project
├── com.clickbus.placesmanager
│   ├── configuration: shared configuration files, such as Swagger and JPA
│   ├── controllers: external UI communication
│   ├── dto - data transfer objects to UI (API responses and requests)
│   ├── entities: domain objects with database annotations.
│   ├── exception: Exception classes that help spring to handle Errors.
│   ├── repository: Spring Data interfaces to communicate with MySQL
│   ├── services: Spring components with business logic.          
│   ├── utils : utilities that can be shared cross application
│       
```

# Requirements / Dependencies
- [Java 8](https://www.java.com/pt_BR/download/)
- [Maven](https://maven.apache.org/) to manage the project's build, reporting and documentation from a central piece of information;
- [Spring boot](https://spring.io/projects/spring-boot) for project setup and run;
- [Lombok](https://projectlombok.org/) To help with some Java boilerplates such as: Getter, Setter, Constructor, etc.. Also automate the creation of a Builder;
- [Model Mapper](http://modelmapper.org/) to make object mapping easy, by automatically determining how one object model maps to another, based on conventions;
- [JUnit4](https://junit.org/junit4/) for unit tests;
- [Mockito](https://site.mockito.org/) for general tests;
- [MockMVC](https://spring.io/guides/gs/testing-web/) from Spring for Rest Tests;
- [Swagger](https://swagger.io/) for really useful and simple API documentation;
- [Docker](https://www.docker.com/) To build container and reduce concerns with infrastructure.

# Running the application locally

- I Have provided two ways of running application locally. It's up to you to choose which one to use.

 ### With Docker
 - Start Docker in your local machine after cloning the project.
 - Run the command below on the root of the project:
  ```
$ docker-compose up --build
  ```
  Please make sure that MySql default port 3306 is not being used.

  ### With Maven  

- Run the command below to compile the project  

```
$ mvn clean install
```

- You can run it with the command below. If you are using modern IDEs such as IntelliJ and Spring Tool Suite, they have built-in spring-boot startup tools.

```
$ mvn spring-boot:run
```

You can build the project with:
 ```
$ mvn clean package
```

## Tests

Tests are separated in Test folder and in sub-folders: 

```
    ├── helper: Package with classes responsible for creating mock entities and lists.
    ├── integration: Integration Tests
    ├── Unit - JUnit tests for services and MockMVC tests for Controllers.
```

## Swagger
- Swagger is already configured in this project in SwaggerConfig.java.
- The API can be seen at http://localhost:8080/swagger-ui.html.
- You can also try the entire REST API directly from the Swagger interface!

## Postman Documentation

Alternatively to swagger, I have prepared a postman documentation, in which you will be able to check in details each endpoint and possible Requests and responses.

Please access it by link below:

```
https://documenter.getpostman.com/view/4694407/SWTD7wgP?version=latest#1b2e87ca-1b80-4823-a64c-b53e23842aaa
```

### Contributors

- Murilo M. Santos <murilommms@gmail.com>

---


## Support

* If you have any query or doubt, please, feel free to contact me by e-mail.



