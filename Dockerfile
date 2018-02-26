FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD moneyfi.jar moneyfi.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/moneyfi.jar"]
