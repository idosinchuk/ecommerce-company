# ecommerce-company Application

# Assignment

Build an application / service in SpringBoot that provides a query rest endpoint following the criteria.

In the ecommerce company database we have the PRICES table that reflects the final price (pvp) and the rate that applies to a product in a
chain between certain dates. Below is an example of the table with the relevant fields:

### PRICES

BRAND_ID START_DATE END_DATE PRICE_LIST PRODUCT_ID PRIORITY PRICE CURR
-------------------------------------------------- -------------------------------------------------- -------------------------------------------------- -------------------------------------------------- ----------------------------------
1 2020-06-14-00.00.00 2020-12-31-23.59.59 1 35 455 0 35.50 EUR

1 2020-06-14-15.00.00 2020-06-14-18.30.00 2 35 455 1 25.45 EUR

1 2020-06-15-00.00.00 2020-06-15-11.00.00 3 35 455 1 30.50 EUR

1 2020-06-15-16.00.00 2020-12-31-23.59.59 4 35 455 1 38.95 EUR

Fields:

BRAND_ID: Foreign key of the group string (1 = BRAND1).

START_DATE, END_DATE: Date range in which the indicated rate price applies.

PRICE_LIST: Identifier of the applicable price list.

PRODUCT_ID: Product code identifier.

PRIORITY: Pricing Disambiguator. If two rates coincide in a range of dates, the one with the highest priority (highest numerical value) is
applied.

PRICE: Final sale price.

CURR: ISO of the currency.

### Criteria

Accept as input the parameters: application date, product identifier, group chain identifier.

Return as output data: product identifier, group chain identifier, price to apply, application dates and final price to apply.

You must use a database in memory (type h2) and initialize with the data of the example, (you can change the name of the fields and add new
ones if you want, choose the type of data that is considered appropriate for them).

### Testing Criteria

Develop some tests to the rest endpoint that validate the following requests to the service with the data from the example:

- Test 1: request at 10:00 on the 14th of product 35455 for brand 1 (BRAND1)
- Test 2: request at 16:00 on the 14th of product 35455 for brand 1 (BRAND1)
- Test 3: request at 21:00 on the 14th of product 35455 for brand 1 (BRAND1)
- Test 4: request at 10:00 on the 15th of product 35455 for brand 1 (BRAND1)
- Test 5: request at 21:00 on the 16th of product 35455 for brand 1 (BRAND1)

### To consider

It will be valued:

- Design and construction of the service.

- Quality of Code.

- Correct results in the tests.

# Prerequisites

Running, debugging and editing the source code requires the following tools to be installed on your machine

- [OpenJDK 11 SDK](https://jdk.java.net/java-se-ri/11) (other JDKs version 11 or higher probably work fine too, but I test on OpenJDK 11)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (as with the JDK, other IDEs probably work fine too, I have only tested on IDEA.)
- A tool like [Postman](https://www.getpostman.com/) to easily create, edit and send custom REST calls over HTTP

# Running the application
First, import the project in your IDE. (Note, this has only been tested properly in IntelliJ IDEA).

To run `ecommerce-company`, find the Kotlin class `com.idosinchuk.ecommercecompany.EcommerceCompanyApplication` and run it as a Java
application. No configuration is needed - on every startup, an empty, in-memory database is created.

Open Swagger in the browser at http://localhost:8080/swagger-ui/index.html and call the endpoints based on the documentation.

# Running the application from Docker
1. Build the app with `gradle build`

2. Run docker-compose to start Spring Boot Application with H2, SonarQube with `docker-compose up`

# Running tests
To run the automated tests, run all JUnit tests found under src/test/java in your IDE, or from gradle with `gradle clean test`.

# Run Coverage
To run the automated tests with coverage, run all JUnit tests with coverage found under src/test/java in your IDE, or from gradle
with `gradle test jacocoTestReport`.

This will, by default, generate html reports in the build/reports/jacoco/ folder.


# Accessing the in-memory database directly
If you want to query or edit the in-memory H2 database directly, you can use the embedded H2 console located
at http://localhost:8080/h2-console. The correct settings (which should be the default) are:

- Driver class: `org.h2.Driver`
- JDBC URL: `jdbc:h2:mem:ecommerce-companydb`
- User name: `sa`
- Password: empty

# Monitoring with Actuator
Access with http://localhost:8080/actuator

# Monitoring with Prometheus
Access with http://localhost:8080/actuator/prometheus

# Prometheus Dashboard
Access with http://localhost:9090/targets

# Grafana Dashboard
Access with http://localhost:3000

The login credentials by default are:
- Username: `admin`
- Password: `admin`

# Code quality with SonarQube

Run: `gradle clean build jacocoTestReport`
Run: `sonar-scanner`

The project has been analyzed with SonarLint following the strictest rules and best programming practices.

Access with http://localhost:9000

# Technology stack
The `eccomerce-company` technology stack consists of:

- [Spring Boot 2.6.5](http://docs.spring.io/spring-boot/) as base application layer.
- [Java 11](https://docs.oracle.com/en/java/javase/11/) as code language.
- [Gradle 8.0](https://docs.gradle.org/current/userguide/userguide.html) as a build automation tool.
- [OpenApi 3](https://swagger.io/specification/) as an interface to RESTful APIs.
- [RAML 3](https://raml.org/) as a modeling language to RESTful APIs.
- [H2 2.1.210](http://www.h2database.com/html/main.html) as in-memory database.
- [Caffeine 3.0.6](https://github.com/ben-manes/caffeine) as in-memory cache.
- [Spring Data JPA 2.6.5](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/) for database access.
- [Flyway](https://flywaydb.org/) for dealing with database schema migrations.
- [JUnit 5.8.2](https://martinfowler.com/bliki/DomainDrivenDesign.html) as a unit testing framework.
- [Jacoco](https://www.jacoco.org/jacoco/trunk/doc/) as code coverage metric provider.
- [DDD](https://martinfowler.com/bliki/DomainDrivenDesign.html) as an approach to software development.
- [Hexagonal Arquitecture](https://alistair.cockburn.us/hexagonal-architecture/) As a software architecture pattern.
- [Spring Boot Actuator](https://prometheus.io/docs/introduction/overview/) as a monitoring and managing tool.
- [Prometheus](https://prometheus.io/docs/introduction/overview/) as a system monitoring and alerting toolkit.
- [Grafana](https://grafana.com/docs/) as an analytics and interactive visualization tool.
- [Docker](https://docs.docker.com/) as a containerization platform.

