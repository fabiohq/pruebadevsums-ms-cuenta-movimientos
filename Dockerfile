FROM openjdk:17
VOLUME /tmp
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT java ${JAVA_OPTS} -jar app.jar