# our base build image
FROM maven:latest

# copy the project files
COPY ./pom.xml ./pom.xml

# build all dependencies
RUN mvn dependency:go-offline -B

# copy your other files
COPY ./src ./src

## build for release
RUN mvn install -DskipTests

ENTRYPOINT ["mvn", "spring-boot:run"]
