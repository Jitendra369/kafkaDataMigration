**Kafka Integration System**

**Overview
**
 This project demonstrates a Kafka-based architecture where data is transferred between two Spring Boot applications — one acting as a Producer and the other as a Consumer — with a shared common module (common-dto) used by both.
Data is initially fetched from a MySQL database on the producer side and then updated into a PostgreSQL database on the consumer side using Kafka for communication and JPA for database interaction.

**kafka-integration-system/**
├── common-dto/         # Shared module containing DTOs (UserDto) used by both apps
├── kafka-producer/     # Reads data from MySQL and sends to Kafka
├── kafka-consumer/     # Reads data from Kafka and writes to PostgreSQL


**Flow Description**
**Producer Application**

Reads records from MySQL using JPARepository.

Converts domain entities (User) to shared UserDto.

Sends serialized UserDto messages to a Kafka topic.

Kafka

Acts as a broker for message transmission.

Topic: UPDATE_USER_TOPIC.

**Consumer Application**

Listens to Kafka topic.

Deserializes UserDto and converts it to Employee entity.

Saves data to PostgreSQL using JPARepository.
**
Modules Explained**
common-dto
Contains shared UserDto class.

Packaged as a Maven/Gradle dependency for reuse in both apps.

**kafka-producer**
Reads user data from MySQL.

Sends UserDto messages to Kafka.

**kafka-consumer**
Consumes UserDto from Kafka.

Maps to Employee entity.

Writes data to PostgreSQL.

**🔗 Communication**
Kafka Topic: UPDATE_USER_TOPIC

Data Format: JSON

Serializer: JsonSerializer / JsonDeserializer
