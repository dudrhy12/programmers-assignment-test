# Problem 4 — Todo List API

## 문제 설명

할 일(Todo) 목록을 관리하는 REST API를 구현한다.

API 서버는 할 일을 생성하고, 등록된 할 일 목록을 조회하며, 지정한 할 일을 삭제할 수 있어야 한다.

본 프로젝트는 원본 과제를 Java와 Spring Boot로 연습하기 위해 별도로 구현한 프로젝트이다. 원래 과제가 Vanilla JavaScript 기반인 경우, 원본 과제의 JavaScript 테스트와는 별개이다.

## 구현 기능

### 1. 할 일 생성

- 클라이언트 요청을 받아 새로운 할 일을 등록한다.
- 요청 본문에 필요한 값이 포함되어 있는지 확인한다.
- 생성 결과를 적절한 HTTP 상태 코드와 JSON 형식으로 반환한다.

### 2. 할 일 목록 조회

- 등록된 할 일 목록을 조회하여 반환한다.
- 데이터가 없는 경우에도 정해진 응답 형식을 따른다.

### 3. 할 일 삭제

- 요청으로 지정된 할 일을 삭제한다.
- 해당 할 일이 존재하지 않는 경우 적절한 오류 응답을 반환한다.

## 기술 스택

- Java 17
- Spring Boot
- Gradle
- IntelliJ IDEA

## 프로젝트 구조

```text
Problem4/
├── build.gradle
├── settings.gradle
└── src/
    └── main/
        └── java/
            └── project/
                └── App.java
```

## 실행 방법

1. IntelliJ IDEA에서 프로젝트를 연다.
2. Gradle 동기화가 완료될 때까지 기다린다.
3. `src/main/java/project/App.java` 파일을 연다.
4. `main()` 메서드를 실행하여 서버를 시작한다.
5. API 요청을 보내 각 기능이 정상적으로 동작하는지 확인한다.

## 학습 목표

- Spring Boot를 이용한 REST API 구현
- `@GetMapping`, `@PostMapping`, `@DeleteMapping` 사용
- 요청 파라미터와 JSON 본문 처리
- 리스트를 활용한 데이터 추가, 조회, 삭제
- HTTP 상태 코드 및 JSON 응답 처리

## 참고 사항

이 프로젝트는 Java와 Spring Boot를 활용한 학습용 구현이다. 정확한 API 경로, 요청 및 응답 형식, 오류 상태 코드는 원본 과제의 요구사항을 기준으로 확인한다.

원본 과제의 JavaScript 테스트를 실행하거나 통과하기 위한 프로젝트는 아니다.
