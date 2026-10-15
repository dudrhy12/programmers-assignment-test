# Problem 5 — Post API

## 프로젝트 소개

Java와 Spring Boot를 사용해 게시글 데이터를 조회하고 조건에 따라 필터링하는 API를 연습하는 프로젝트입니다.

원본 과제의 JavaScript 테스트를 그대로 통과하기 위한 프로젝트가 아니라, 과제의 핵심 기능을 Java/Spring Boot로 구현하며 REST API와 데이터 처리 방식을 학습하기 위한 연습 프로젝트입니다.

## 주요 기능

- 게시글 데이터 조회
- 작성자 정보 기반 게시글 필터링
- 요청 파라미터에 따른 데이터 처리
- REST API 응답 구성

## 기술 스택

- Java 17
- Spring Boot
- Gradle
- IntelliJ IDEA

## 프로젝트 구조

```text
Problem5/
├── build.gradle
├── settings.gradle
└── src/
    └── main/
        └── java/
            └── project/
                └── App.java
```

## 실행 방법

1. 프로젝트를 다운로드하거나 GitHub에서 클론합니다.
2. IntelliJ IDEA에서 프로젝트를 엽니다.
3. Gradle 동기화가 완료될 때까지 기다립니다.
4. Java 17이 설정되어 있는지 확인합니다.
5. `App.java`의 Spring Boot 애플리케이션을 실행합니다.

## 학습 목표

- Spring Boot를 이용한 REST API 구현
- Java 컬렉션을 활용한 데이터 처리
- 조건에 따른 게시글 필터링
- HTTP 요청과 JSON 응답 이해
- IntelliJ IDEA와 Gradle을 활용한 프로젝트 관리

## 참고 사항

이 프로젝트는 Java/Spring Boot 학습용으로 구성되었습니다.

실제 과제의 API 경로, 요청 파라미터, 응답 형식 및 오류 처리 기준은 원본 문제의 요구사항에 맞춰 확인하고 구현해야 합니다.
