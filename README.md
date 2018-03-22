#Dockerize Spring Boot Application.

In this doc we will build a simple spring boot application which will run inside docker container.

##prerequisite

* Docker version "17.12.1-ce"
* Java version "1.8.0_161"
* Apache Maven "3.3.9"
* Spring Tool Suite "3.9.2"
* MongoDB "3.2.19"

## Install required software

please make sure that you have all the softwares and tool installed on your system.

## Create and run spring boot application

Create a simple spring boot application or you can simply clone it from following git repository.

```
https://github.com/ajaykangare/springboot_login_webapp.git
```

Firstly clone this app on your system and  run it from STS or go inside folder and run using maven.

```
mvn clean install
```

This will genrate some build file and jar file of project in target folder.

Run this project using following command.

```
mvn spring-boot:run
```

Now you can see your app is running on 8080 port locally.Now we want create docker image of this application.stop running application by ```ctrl+c ```

# Docker

Docker is way to develop, deploy and run applications with containers. Container is created by running docker image. An image is executable package that includes everything need to run an application.In basic container is like virtual machin but container are more lightweight,portable,scalable and flexible. Please read this [official doccumentation](https://docs.docker.com/get-started/) for more information.

## Containerize the Spring Boot application

We will containerize created spring boot application using Dockerfile. Dockerfile contains java a base image and we ADD jar file of project to container as app.jar and then executed in ENTRYPOINT .

### Dockerfile

If you dont have dockerfile create file named Dockerfile add the following contents.

```
FROM java:8
ADD /target/Springboot_login_webapp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
```

### Build docker image from dockerfile

Run below command in terminal to create docker image of above application. `-t`   option is for giving tag to image and `.`is for current directory. 

```
docker build -t springboot_login_webapp . 
```

you can check docker images by running following command

```
mindstix@mindstix-Inspiron-3542:~$ docker images
REPOSITORY                            TAG         IMAGE ID        CREATED         SIZE
ajaykangare/springboot_login_webapp   latest      962ba3de82f8    4 hours ago     684MB
springboot_login_webapp               latest      85f1f52afcae    5 hours ago     684MB

```

Our application require mongo as database so we link mongo cotainer with our application. So need to pull docker image from dockerhub repository.

```
docker pull mongo
```

Create container of mongo docker image.

```
docker run -d -p 27017:27017 --name=mongo mongo
```

Like images you can check running container also.

```
docker ps
```

Now run our application i.e. run image.

```
docker run -p 8080:8080 --link=mongo springboot_login_webapp
```

Now your application is running on localhost. This is available and can be accessed from [http://localhost:8080/allusers]() 



Hope this doccumentation help to create ,build and run docker image of spring boot application.