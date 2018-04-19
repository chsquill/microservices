FROM java:8
WORKDIR /
RUN mkdir /tmp/config-repo
ADD config.server-0.0.1-SNAPSHOT.jar config.server-0.0.1-SNAPSHOT.jar
EXPOSE 8888
CMD java -jar config.server-0.0.1-SNAPSHOT.jar
 
