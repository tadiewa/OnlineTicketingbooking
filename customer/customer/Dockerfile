FROM openjdk:17.0.6
EXPOSE 8102
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} customer.jar
ENTRYPOINT ["java","-jar","/customer.jar"]