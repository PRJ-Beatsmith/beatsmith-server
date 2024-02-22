FROM eclipse-temurin:21-jdk-alpine

# Variablen
EXPOSE 8080
ENV MAVEN_HOME /usr/share/maven
ARG MAVEN_VERSION=3.9.6
ARG USER_HOME_DIR="/root"
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

RUN apk update && apk upgrade && \
    apk add --no-cache git bash procps curl tar

# Maven Installation
COPY --from=maven:3.9.6-eclipse-temurin-21 ${MAVEN_HOME} ${MAVEN_HOME}
COPY --from=maven:3.9.6-eclipse-temurin-21 /usr/local/bin/mvn-entrypoint.sh /usr/local/bin/mvn-entrypoint.sh
COPY --from=maven:3.9.6-eclipse-temurin-21 /usr/share/maven/ref/settings-docker.xml /usr/share/maven/ref/settings-docker.xml

RUN ln -s ${MAVEN_HOME}/bin/mvn /usr/bin/mvn

ENTRYPOINT ["/usr/local/bin/mvn-entrypoint.sh"]

# Git Setup
ARG GITHUB_USER=github@deployment.beatsmith.de
ARG GITHUB_TOKEN=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

RUN git config --global credential.helper '!f() { sleep 1; echo "username=${GITHUB_USER}"; echo "password=${GITHUB_TOKEN}"; }; f'
RUN git clone --recursive https://github.com/PRJ-Beatsmith/beatsmith-server.git

# Build und ausführung des Servers
WORKDIR "/beatsmith-server/Beatsmith-Server"
RUN ["mvn", "clean", "install"]
CMD ["java", "-jar", "-Dspring.profiles.active=prod", "/beatsmith-server/Beatsmith-Server/target/Beatsmith.jar"]
