FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/ajaykangare/springboot_login_webapp.git
WORKDIR /app/springboot_login_webapp

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/springboot_login_webapp /app 
RUN mvn install

FROM java:8
WORKDIR /app
COPY --from=build /app/target/Springboot_login_webapp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo/test", "-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
