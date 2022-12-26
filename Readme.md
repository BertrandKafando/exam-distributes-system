##  Examen Systèmes Distribués:

            Archictecture du prjet


[👉 Creation de exam-distributed-system ](./src/main) 

```
C'est le projet central
spring boot 2.5.3 
```
> [stacks & packages](./pom.xml)
```
    -spring web
    -spring data jpa
    -h2
    -lambock
    -axon framework
    -kotlin
    -eureka discovery service
 ```

> [configuration](./src/main/resources/application.properties)
```
...
```
<br>
<br>
<br>
<br>
<br>



[👉 Creation de common-api ](./common-api)

 ```
 un projet Maven contenant les différents elements communs des micro services DTOS,Events,...
 ```
>[stacks && packages](./common-api/pom.xml)
```
-project exam-distributed-system as parent
```

<br>
<br>
<br>
<br>
<br>


[👉 Creation du microservice customer-service ](./customer-service)
 ```
Le micro-service qui permet de gérer les clients.
 ```
>[stacks && packages](./customer-service/pom.xml)
```
-project exam-distributed-system as parent
-comman-api 
```

> [configuration](./customer-service/src/main/resources/application.properties)
```
...

```

>[customer-service-command-side](./customer-service/radar-command-side)
```
-8081
-customer-service as parent
spring.application.name=customer-service-command-side
```

>[customer-service-query-side](./customer-service/radar-query-side)
```
-8082
-customer-serviceas parent

spring.application.name=customer-service-query-side
spring.datasource.url=jdbc:h2:mem:customer-service_db
spring.h2.console.enabled=true
server.port=8082
axon.axonserver.servers=localhost
axon.axonserver.enabled=true
eureka.client.enabled=false/true

```

<br>
<br>
<br>
<br>
<br>


