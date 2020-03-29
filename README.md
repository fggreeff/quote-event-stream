# quote-event-stream

This service streams quote events using [eventstore](https://eventstore.com/) to SQL DB for the data analysts to produce reports. This captures user behaviour as they are completing quote steps to help determine the number of products “active” in a quote at any one time.

### Architecture

![Architecture](./local_setup/diagrams/architecture.png)

### ERD

![ERD](./local_setup/diagrams/quote_stream_erd.png)

## Getting started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites

A detailed, step by step guide, of the setup of any external dependencies that a service/project may have, including node, dotnet core, and docker.

### Event store
[Event Store](https://eventstore.com/docs/getting-started/index.html)

You have two options of running the Event Store, either a pre-configured connection or local setup:

#### Pre-configured 
EventStore Connection Details
- [Web URL: http://167.99.81.240:2113/](http://167.99.81.240:2113/)
- [TCP URL: tcp://167.99.81.240:1113/](tcp://167.99.81.240:1113/)

#### Local setup
Install and run event store locally `bash local_setup/event_sink_setup.sh`

EventStore connection details
- [Web URL: 127.0.0.1:2113](http://127.0.0.1:2113/)
- [TCP URL: tcp://127.0.0.1:1113](tcp://127.0.0.1:1113/)
- Username: `admin`
- Pass: `changeit`

### MySQL

I'd recommend installing [JetBrains DataGrip](https://www.jetbrains.com/datagrip/features/mysql.html) IDE for working with SQL and databases
- Default port 3306 used for the connection
- Once installed, create the schema [scripts](./scripts/000_create_schema.sql)

## Installing

Step by step instructions on how to get a working version of the project on your local machine, such as

- Clone repository
- Run `mvn clean install` 
- Run `bash local_setup/service_startup.sh` to start mysql in docker (script also sets env vars)
- Run `RunEventStore` for reading events (WIP)
- Run `RunWebService` and visit [localhost](http://localhost:8080/) for mapping ORM to mySQL relational DB (WIP)

# Running the tests

An explanation on how to run any automated tests that relate to the project. (WIP)

# Clean up

remove any unused containers `docker system prune -a`
remove any unused volumes `docker volume prune`

# Source

 * [EventStore Docs](https://eventstore.com/docs/)
 * [Java 8](https://www.java.com/pt_BR/download/faq/java8.xml)
 * [Spring Boot](https://spring.io/projects/spring-boot)
 * [DataGrip](https://www.jetbrains.com/datagrip/features/mysql.html)
 * [mysql Docker](https://hub.docker.com/_/mysql)
 * [sql instance with Docker](https://medium.com/@chrischuck35/how-to-create-a-mysql-instance-with-docker-compose-1598f3cc1bee)
