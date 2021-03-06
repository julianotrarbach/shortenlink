# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

#### Using docker-compose
* Create the database in the docker, and a dockerfile to create the application.
* Make sure the following excerpt looks like this in the application.properties file:
  * spring.datasource.url=jdbc:mysql://db:3306/shortenlinkapi_db?allowPublicKeyRetrieval=true&useSSL=false
* Open the windows prompt and navigate to the root of the project: 
* execute: cd C:\workspace\shortenlink
* execute: docker-compose run db
* execute: docker-compose run app-server
* if you dosent work, you can execute "docker-compose down --rmi all" before this command and try again.
* To access the web application, simply go to (http://containerip:8081/)
* To access the API documentation, simply go to (http://containerip:8081/swagger-ui.html)


### Using a BAT windows command
#### Before anything

* Open the command prompt, and navigate to the project root
  * windows example: cd c:\workspace\shortenlink
* run the create_docker_db.bat file
  * This command will create an image in the mysql database docker, which can be accessed through localhost:3309

#### Execution of the Web Application / API project by eclipse, or another IDE

* Make sure the following excerpt looks like this in the application.properties file:
  * spring.datasource.url=jdbc:mysql://localhost:3309/shortenlinkapi_db?allowPublicKeyRetrieval=true&useSSL=false
* To access the web application, simply go to (http://localhost:8081/)
* To access the API documentation, simply go to (http://localhost:8081/swagger-ui.html)

