# springboot3-ddd-style

## Implementation using ddd style

---
## Project 
### Version
```
- Spring-Boot 3.3.4
- Jdk 21, Kotlin 1.9.2
- Gradle 8.5
```
* 스프링부트 최신인 3.4에 대한 이슈가 있는 듯하여, 3.3의 GA인 3.3.6을 선택
    * Jdk17 ~ Jdk21 선택 가능
* Gradle build version 을 참고하여 8.5 를 선택
    * https://docs.gradle.org/current/userguide/compatibility.html

### 도커 실행
* 프로젝트 실헹에 필요한 리소스들을 띄운다
```bash
docker-compose up -d
```

### 빌드 및 프로젝트 실행
```bash
./gradlew wrapper --gradle-version=8.5 --distribution-type=bin
./gradlew -v
./gradlew clean build -xtest
./gradlew bootRun
```

### 스웨거
* http://localhost:8080/swagger-ui.html
