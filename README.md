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


####  Questions
- What concerns would you have on your SQL with a much larger data set?
Analysts could run multiple queries that will cause slow down. 
Some ideas: 
Identify bottlenecks running SQL Profiler to analyse query usage and execution numbers.
Running DB optimisation by looking at how analysts use DB for searching / querying.
Consider fields & tables for indexing
Consider running overnight batch jobs using DP / Airflow 
Consider scaling vertically 

- Did you encounter any invalid data?
I have not yet parsed the data. There will most definitely be invalid data, possibly around data types & data format :) 

- What language did you select to implement this challenge? Why?
It would have been between Scala and Java. As I am new to the Java world and wanted to learn the language whilst doing this challenge. 
Java lends itself to OOP and from Java 8 it lends itself more to functional programming. There are very well known streaming tools, such as kafka which are built on the JDK. 
Giving the benefit of making use of kstreams and kSQL. Java provides Hibernate which is great for ORM mapping and creates a good standard for team members to follow.
Saying all this, it took me some time to get my head around setting up Hibernate and SpringBoot this weekend. 

- What would you do differently to your implementation if you had more time?
I'd look at a comparison between using Gson or Jackson Object mapper for mapping the Json to Java Objects.
I would then look more at the json data to determine what fields I really want to extract and how my objects should reflect the data. 
I'd include metadata and event version numbers etc. 
I would look at de-coupling the ETL. Example, I would look at introducing a Kafka broker, as the transformation of data can grow and create a bottleneck.
A intermediate kafka broker would also act as a buffer, as one micro-service would need to scale and should have a single responsibility. 
Introduce a DLQ for serialisation issues etc. 
Add health check for services.

- What technologies would you use run this service?
Java, Parquet, Docker, K8s, Snowflake

- What testing did (or would) you do, and why?
I didn't get around to add tests. Basic unit tests for logic & functionality. Including:
Deserialize event, Filter events, Transform, Pub / Sub functionality. Any DQ & transformation checks should live outside the streaming app and can be tested there

Thank you for the challenge