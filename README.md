##Monitoring spring-boot project with kamon-annotations, influxdb and grafana
Execute 
```
mvn clean install 
```
to build the project. Next as mentioned in Kamon.io Documentation, execute via:
```
mvn spring-boot:run
```
Project contains aspectj-weaver dependency, so it is not required to provide VM options for execution.


Other option to execute is following exact same steps provided in documentation

```
mvn package && java-javaagent:/Path/to/aspectjweaver.jar -jar /target/project.jar
```
The project contains aspectjweaver.jar file.

You can update influx-db configuration from application.conf 

The project also houses docker-compose for installing influxdb-grafana, you can execute it via

```
docker-compose up
```