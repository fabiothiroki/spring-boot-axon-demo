# spring-boot-axon-demo

## Local development

### Install and run external dependencies (Mongo and Postgres):
```bash
docker-compose up
```

### Build the project:
```bash
./gradlew clean assemble
```

### Run the Command Side module:
```bash
java -jar commandside/build/libs/commandside.jar
```

### Run the Query Side module:
```bash
java -jar queryside/build/libs/queryside.jar
```