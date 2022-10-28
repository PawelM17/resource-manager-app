FROM openjdk:16
ADD out/artifacts/resource_manager_app_jar/resource-manager-app.jar .
EXPOSE 8080
CMD java -jar resource-manager-app.jar
