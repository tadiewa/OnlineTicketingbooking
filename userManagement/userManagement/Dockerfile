FROM openjdk:17
EXPOSE 8097
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} userManagement.jar
ENTRYPOINT ["java","-jar","/userManagement.jar"]
