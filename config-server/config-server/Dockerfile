FROM openjdk:17.0.6
EXPOSE 8098
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} configserver.jar
ENTRYPOINT ["java","-jar","/configserver.jar"]