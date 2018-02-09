FROM openjdk

EXPOSE 8761
ADD target/*.jar /app.jar
RUN bash -c 'touch /app.jar'
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]