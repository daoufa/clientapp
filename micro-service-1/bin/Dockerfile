FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8086
ADD target/ebanking.jar ebanking.jar
ENTRYPOINT ["java","-jar","/ebanking.jar"]