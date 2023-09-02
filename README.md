## Project Requirement

- [ ] JDK 17 ↑
- [ ] Maven 3.8 ↑

***
## Run Project
```
mvn -DskipTests spring-boot:run
```

## 


***

# Build Setting

#### Set Java_Home to Graalvm path
```
$PATH=<Graalvm_Path>/bin:$PATH
```

#### Install Native Image plugin
```
cd <Graalvm_Path>/bin
./gu install native-image
```

### package all basic components  
```
mvn clean install -pl <target-service>
```

#### Clean old pom & jar then compile
```
mvn clean package -Pnative -DskipTests -pl <target-service> -Denv.project.version=${version}
```

#### Build to executable image (Native Image)
```
mvn -Pnative -DskipTests native:compile -pl <target-service> -Denv.project.version=${version} 
```

#### Build spring app to deployment image
```
mvn spring-boot:build-image -Denv.project.version=${version}
```

#### Run debug mode
```
docker run -p <service-port> -p 8000:8000 --env-file <mm-project/_evn/dev.env> -it --name <target-service> <code>
```
