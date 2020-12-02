FROM openjdk:8
EXPOSE 8001
VOLUME /tmp
ADD ./target/usertest-0.0.1-SNAPSHOT.jar usertest.jar
ENTRYPOINT ["java","-jar","/usertest.jar"]