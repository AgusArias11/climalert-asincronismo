# ==========================
# Etapa 1: Build de Maven
# ==========================
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copiar todo el proyecto
COPY . .

# Compilar (sin tests)
RUN mvn clean package -DskipTests


# ==========================
# Etapa 2: Imagen final
# ==========================
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiar el JAR generado
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]