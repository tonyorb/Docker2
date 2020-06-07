FROM maven:3.6.3-jdk-11
COPY src /home/app/src
COPY pom.xml /home/app
WORKDIR /home/app/
RUN mvn -f /home/app/pom.xml dependency:resolve
EXPOSE 4444

