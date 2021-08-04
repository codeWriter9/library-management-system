FROM adoptopenjdk/openjdk8:latest
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} library-management-system-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/library-management-system-0.0.1-SNAPSHOT.jar"]
