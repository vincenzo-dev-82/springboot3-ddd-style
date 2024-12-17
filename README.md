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

## How to ?
### Enum 처리의 원칙 Domain Layer (Entity):
```
enum 값은 도메인 모델에서 의미를 표현해야 하며, 비즈니스 로직의 일부로 취급됩니다.
@Enumerated를 사용해 데이터베이스와 매핑합니다.
도메인 계층 내에서 값 변환 및 검증 로직을 처리할 수 있습니다.

Application Layer:
enum을 직접 노출하기보다 **DTO(Data Transfer Object)**나 Mapper를 사용해 변환합니다.
Presentation Layer와 도메인 계층 간의 의존성을 줄이기 위해 enum 값을 문자열이나 다른 표현으로 변환하여 사용합니다.

Presentation Layer:
클라이언트가 이해하기 쉽도록 직렬화된 형태로 값을 반환합니다(예: JSON).
사용자가 요청하는 값을 문자열로 받아 도메인 계층의 enum으로 변환하는 로직을 처리합니다.
```
