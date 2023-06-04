FROM openjdk:17
EXPOSE 8099
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} discovery.jar
ENTRYPOINT ["java","-jar","/discovery.jar"]
