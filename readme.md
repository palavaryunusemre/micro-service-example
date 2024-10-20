# Microservis Example

Bu proje, Spring Boot tabanlı bir Java uygulamasıdır ve çeşitli Spring Cloud bileşenlerini içermektedir.

## Teknolojiler ve Araçlar

- Java 17
- Spring Boot 3.3.1
- Spring Cloud 4.1.3
- Gradle 
- PostgreSQL 42.7.4
- MongoDB
- Redis
- OpenFeign
- Swagger UI 2.6.0
- Lombok 1.18.34
- JUnit (test için)

## Bağımlılıklar

Proje aşağıdaki ana bağımlılıkları kullanmaktadır:

- Spring Boot Starter Web
- Spring Boot Data JPA
- Spring Boot Data Redis
- Spring Boot Data MongoDB
- Spring Cloud Starter OpenFeign
- Spring Cloud Config (Server ve Client)
- PostgreSQL JDBC Driver
- Lombok
- SpringDoc OpenAPI UI (Swagger)

## Kurulum

1. Bu repository'yi klonlayın:
   ```
   git clone https://github.com/palavaryunusemre/micro-service-example
   ```
2. Projeyi IDE'nizde açın.
3. Gradle bağımlılıklarını yükleyin.
4. Gerekli veritabanlarını (PostgreSQL, MongoDB, Redis) kurun ve yapılandırın.


## Konfigürasyon

Proje, Spring Cloud Config kullanmaktadır. Konfigürasyon ayarlarını uygun şekilde yapılandırdığınızdan emin olun.

## Mikroservis Mimarisi

Bu proje, mikroservis mimarisini desteklemektedir. Spring Cloud bileşenleri (OpenFeign, Config Server/Client) bu amaçla entegre edilmiştir.

## Docker konteynerlarının içeri aktarılması

````bash
docker run -d --name postgresql -p 5432:5432 muhammedali55/postgresql:v.0.1

````

````bash
docker run -d --name mongodb -p 27017:27017 muhammedali55/mongodb:v.0.3

````

## Docker üzerinde Redis Single Node oluşturmak.

```bash
    docker run --name microservice-redis -p 6379:6379 -d redis
```

```bash
    docker run --name redis-gui -d -p 8001:8001 redislabs/redisinsight:1.14.0
```
