FROM openjdk:17-oracle
COPY target/ServerManagementAnalyser-0.0.1-SNAPSHOT.jar analyser.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "analyser.jar"]
