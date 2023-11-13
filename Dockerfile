FROM openjdk:17
COPY target/rabbitmq-0.0.1-SNAPSHOT.jar /bazarik-rabbitmq.jar
EXPOSE 5672
EXPOSE 15672
ENTRYPOINT ["java", "-jar", "bazarik-rabbitmq.jar"]
