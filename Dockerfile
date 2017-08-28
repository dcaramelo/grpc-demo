FROM maven:3-jdk-8

WORKDIR /var/app/grpc

COPY . /var/app/grpc

RUN mvn install

EXPOSE 50052 5000

CMD ["java", "-jar", "target/grpc-demo-0.1.0.jar"]
