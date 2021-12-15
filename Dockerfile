ARG DOCKER_IMAGE_BUILDER=gradle:6.9.1-jdk11
ARG DOCKER_IMAGE_RUNNER=registry.access.redhat.com/ubi8/openjdk-11
FROM ${DOCKER_IMAGE_BUILDER} AS builder
COPY . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle build
### Package stage
FROM ${DOCKER_IMAGE_RUNNER}
COPY --from=builder /home/gradle/project/* /deployments/
EXPOSE 8888
WORKDIR /deployments
