
FROM java:8
ADD mall-1.0-SNAPSHOT.jar /mall.jar
RUN bash -c 'touch /mall.jar'
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/mall.jar"]
MAINTAINER yangzi