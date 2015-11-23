# Welcome to the Karting (or Racing) Times Application #

I implemented this application while reading about microservices in Java.

## System requirements ##

What you need to build and run this application:
* [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3](https://maven.apache.org/download.cgi)
* [Docker](https://www.docker.com/) (not needed but it very useful and good fun)
* [Docker Compose](https://docs.docker.com/compose/) (not needed but it very useful and good fun)

## Design ##
The application is built with five components:
* Registration Server - binds together all microservices
* Drivers Server microservice - handles drivers in its own database
* Tracks Server microservice - handles tracks in its own database
* Laptimes Server microservice - handles laptimes in its own database
* Web Server - the web front

### Data exchange format ###
All microservices use json for exchanging data.

## Build and run using Docker ##
_mvn install_
This builds the application and creates docker images for it.

_cd docker_
_docker-compose up_
This runs all microservices.

### Build and run without Docker ###
Why aren't you using Docker? :)

Start all the five applications manually in your IDE or from the command line.
You'll have to start with the Registration Server and wait until it's fully started.
Then start Drivers Server, Tracks Server, Laptimes Server and finish up with the Web Server.

## Try it ##
After all applications been started you can access:
* web front at [http://localhost:8080](http://localhost:8080)
* Registration Server at [http://localhost:1111](http://localhost:1111)
* Driver Server at [http://localhost:1111](http://localhost:2222)
* Tracks Server at [http://localhost:3333](http://localhost:3333)
* Laptimes Server at [http://localhost:4444](http://localhost:4444)

Sometimes it takes a while for the clients to register themselves in the Registration Server so be patient. :)

### Questions or comments? ###

Talk to peter@westlin.nu.
