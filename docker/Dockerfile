# our base build image
FROM maven:latest

# copy the project files
COPY ./pom.xml ./pom.xml

# build all dependencies
RUN mvn dependency:go-offline -B

# copy your other files
COPY ./src ./src

COPY ./docker/wait_for_db.sh ./wait_for_db.sh

## build for release
RUN mvn clean install -Dmaven.test.skip=true

ENTRYPOINT ["mvn","spring-boot:run"]
