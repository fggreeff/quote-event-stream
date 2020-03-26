# quote-event-stream

This service streams quote events using (eventstore)[https://eventstore.com/] to SQL DB for the data analysts to produce reports. This captures user behaviour as they are completing quote steps to help determine the number of products “active” in a quote at any one time.

## Getting started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See the deployment section for notes on how to deploy the project on a live system.

## Prerequisites

A detailed, step by step guide, of the setup of any external dependencies that a service/project may have, including node, dotnet core, and docker.
(Event Store)[https://eventstore.com/docs/getting-started/index.html]

You have two options of running the Event Store, either a pre-configured connection or local setup:

#### Pre-configured 
EventStore Connection Details
- (Web URL)[http://167.99.81.240:2113/]
- (TCP URL)[tcp://167.99.81.240:1113/]
- Username: `xxx`
- Pass: `xxx`

#### Local setup
Install event store `bash local_setup/setup.sh`
Run the event store `bash local_setup/service_startup.sh`

EventStore connection details
- (Web URL)[http://127.0.0.1:2113/]
- (TCP URL)[tcp://127.0.0.1:1113/]
- Username: `admin`
- Pass: `changeit`

## Installing

Step by step instructions on how to get a working version of the project on your local machine, such as

- Clone repository
```
$ git clone <repo>
$ cd ./<repo>
```
- Run `mvn clean install` 

# Running the tests

An explanation on how to run any automated tests that relate to the project.

# Deployment

Detail any steps required to deploy the service/project to systems other than the local machine.

# Source

(EventStore Docs)[https://eventstore.com/docs/]
