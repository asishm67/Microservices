FROM openjdk:17-jdk-alpine

# MAINTAINER instruction is deprecated in favor of using label
# MAINTAINER asishtech.com
#Information around who maintains the image
LABEL "org.opencontainers.image.authors"="asishtech.com"
# Add the application's jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#Exicut the application
ENTRYPOINT ["java", "-jar", "/accounts-0.0.1-SNAPSHOT.jar"]