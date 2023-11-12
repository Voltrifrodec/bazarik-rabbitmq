FROM openjdk:17
COPY target/rabbitmq-0.0.1-SNAPSHOT.jar /bazarik-rabbitmq.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "bazarik-rabbitmq.jar"]
