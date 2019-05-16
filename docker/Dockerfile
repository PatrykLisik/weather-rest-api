FROM lpicanco/java11-alpine

# copy the project files
COPY ./pom.xml ./pom.xml

COPY ./target ./target

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "target/nbd5-0.0.1-SNAPSHOT.jar"]
