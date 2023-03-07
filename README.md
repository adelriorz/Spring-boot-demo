# Spring-boot-demo
Java Spring Boot demo application with Postman. Implemented PUT, POST, GET and DELETE methods.

# In case you need to check if port 8080 is busy for localhost:
```
netstat -aon | findstr 9260
```

#1 Run application:
```
cd Spring-boot-demo/demo/demo/target
java -jar demo-0.0.1-SNAPSHOT.jar
```

This will get the application up and running. You should be able to see it at localhost at:
```
localhost/api/v1/student
```

If you want to run the application in a different port repeat 'Run application' by changing:
```
java -jar demo-0.0.1-SNAPSHOT.jar --server.port=<PORT>
```