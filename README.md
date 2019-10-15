# API_excercise

This is a SpringBoot Maven Project.

run ./mvnw clean package 
to build jar file 
run java -jar target/gs-rest-service-0.1.0.jar 

or use ./mvnw spring-boot:run to run service directly

How to use this webservice:

GET http://localhost:8080/  ---get all posts (texts and filenames)


POST http://localhost:8080/ ---uploads file or text

Post method consumes MediaType.MULTIPART_FORM_DATA_VALUE with two optional parameters file and post


How to Dockerizing this application:
https://www.callicoder.com/spring-boot-docker-example/
