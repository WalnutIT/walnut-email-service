FROM centos

RUN yum install -y java

VOLUME /tmp
ADD /email-0.0.1-SNAPSHOT.jar walnut_email_service.jar
RUN sh -c 'touch /walnut_email_service.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/walnut_email_service.jar"]