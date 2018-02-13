FROM openjdk

EXPOSE 8080
ADD target/*.jar /app.jar
RUN bash -c 'touch /app.jar'
ADD wait-for-it.sh /wait-for-it.sh
RUN bash -c 'chmod 777 /wait-for-it.sh'
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]