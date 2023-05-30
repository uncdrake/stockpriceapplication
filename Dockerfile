FROM openjdk
COPY target/*.jar /
EXPOSE 8001
ENTRYPOINT ["java","-jar","/StockPriceApplication-0.0.1-SNAPSHOT.jar"]
ENV spring.datasource.url=jdbc:mysql://host.docker.internal:3306/stockpriceapp