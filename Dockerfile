FROM maven:3.9.6-openjdk-11-slim AS build
WORKDIR /app

COPY pom.xml .
COPY admin/pom.xml admin/pom.xml
COPY service/service-common/pom.xml service/service-common/pom.xml
COPY service/service-product/pom.xml service/service-product/pom.xml
COPY service/service-user/pom.xml service/service-user/pom.xml

RUN mvn dependency:go-offline -B

COPY src ./src
COPY admin/src admin/src
COPY service/service-common/src service/service-common/src
COPY service/service-product/src service/service-product/src
COPY service/service-user/src service/service-user/src

RUN mvn clean package -DskipTests

FROM openjdk:11-jre-slim
WORKDIR /app

COPY --from=build /app/admin/target/laptop-vn-admin-1.0-SNAPSHOT.jar app.jar
COPY --from=build /app/service/service-common/target/laptop-vn-common-1.0-SNAPSHOT.jar lib/service/service-common.jar
COPY --from=build /app/service/service-product/target/laptop-vn-product-1.0-SNAPSHOT.jar lib/service/service-product.jar
COPY --from=build /app/service/service-user/target/laptop-vn-user-1.0-SNAPSHOT.jar lib/service/service-user.jar

EXPOSE 8080

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/laptop-vn
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=17012001

ENTRYPOINT ["java", "-cp", "app.jar:lib/*", "hoavd.demo.laptopvn.admin.LaptopVnAdminApplication"]
