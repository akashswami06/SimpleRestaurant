# SimpleRestaurant
Application which accepts menu items from various serving staff in the restaurant
and process order

# Getting started

## technology stack
- Java 11
- Maven
- Spring boot (2.7.0)
- Apache Kafka
- Zookeeper
## install
1.Install with maven command, all depedencies in order-client and order-server
   ```mvn clean install```
## run
1. Run Kafka and Zookeeper using Docker from Parent directory

```docker-compose up```
2. Start order-client microservice

```mvn spring-boot:run```

3. Start order-server microservice

   ```mvn spring-boot:run```


   