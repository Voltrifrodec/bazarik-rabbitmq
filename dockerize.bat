docker compose down;
mvn clean install;
docker build -t bazarik-rabbitmq .;
docker compose up;