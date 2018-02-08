FROM openjdk

VOLUME /tmp
ADD maven/ecom-catalogs-0.0.1.jar myapp.jar
EXPOSE 8080
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]

