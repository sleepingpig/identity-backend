#FROM blueimp/geckodriver:latest
FROM selenium/standalone-firefox:3.141.59

USER root
#RUN apt update
#RUN apt install -y openjdk-11-jdk
ENV HOME /root
RUN apt-get update
RUN apt-get install -y maven
RUN apt-get install -y openjdk-8-jdk
CMD sleep infinity
