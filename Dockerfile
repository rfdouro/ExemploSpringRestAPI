FROM ubuntu:latest AS build

#ARG SUPABASE_DATASOURCE_URL
#ARG SUPABASE_USER
#ARG SUPABASE_PASSWORD

#ENV SUPABASE_DATASOURCE_URL=${SUPABASE_DATASOURCE_URL}
#ENV SUPABASE_USER=${SUPABASE_USER}
#ENV SUPABASE_PASSWORD=${SUPABASE_PASSWORD}

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

RUN mkdir data

EXPOSE 8080

COPY --from=build /target/ExemploSpringRestAPI.jar app.jar

#RUN echo $SUPABASE_DATASOURCE_URL
#RUN echo $SUPABASE_USER

#ENTRYPOINT [ "sh", "-c", "echo $SUPABASE_DATASOURCE_URL" ]
ENTRYPOINT [ "java", "-jar", "app.jar" ]