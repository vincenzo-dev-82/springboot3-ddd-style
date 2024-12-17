# springboot3-ddd-style

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

---
## How to ?

### 아키텍쳐
DDD(Domain-Driven Design) 패키지 구조는 소프트웨어가 해결하고자 하는 비즈니스 문제를 핵심에 두고, 해당 문제를 명확하게 표현하는 모델을 정의하는 것이 목표입니다.
DDD는 도메인 개념을 코드 구조에 반영하여 명확한 책임 분리와 유지보수 용이성을 높입니다.

### 기본적인 DDD 패키지 구조
DDD에서는 애플리케이션의 도메인 개념에 따라 각 기능을 독립적인 모듈로 분리합니다. 주요 패키지 구성 요소는 다음과 같습니다.

1. **Domain (도메인 계층)**
- 도메인 계층은 비즈니스 규칙을 직접 다루는 핵심 영역입니다. 도메인의 핵심 규칙, 로직, 상태 등을 표현합니다.
2. **Application (애플리케이션 계층)**
- 애플리케이션 계층은 사용자의 요청을 처리하고 도메인 계층과 상호작용하여 비즈니스 로직을 실행합니다. 이 계층은 도메인 로직을 사용하지만 그 자체로 비즈니스 규칙을 포함하지 않습니다.
3. **Infrastructure (인프라 계층)**
- 인프라 계층은 데이터베이스나 외부 서비스와의 상호작용을 처리합니다. 또한, 데이터 매핑, 외부 API 통신, 리포지토리 구현체 등을 포함합니다.
4. **Presentation (프레젠테이션 계층)**
- 이 계층은 애플리케이션과 사용자가 상호작용하는 인터페이스를 정의합니다. 컨트롤러는 HTTP 요청을 받고 응답을 생성하는 역할을 합니다.

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
