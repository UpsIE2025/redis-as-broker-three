# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Copia el archivo JAR de tu aplicación
COPY target/AppRedis-0.0.1.jar /app/AppRedis-0.0.1.jar

# Expón el puerto en el que tu aplicación escuchará
EXPOSE 8080

# Comando para ejecutar la aplicación Java
ENTRYPOINT ["java", "-jar", "/app/AppRedis-0.0.1.jar"]