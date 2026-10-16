# Java Stream & Sort Practice

Java Spring Boot와 Stream API를 활용한 유저 데이터 처리 연습 프로젝트입니다.

JSON 파일에 저장된 유저 데이터를 읽어 합계를 계산하고, 정렬 및 필터링, 그룹화하는 REST API를 구현합니다.

## Tech Stack

- Java 17
- Spring Boot 3.4.0
- Gradle
- Jackson
- Java Stream API

## Project Structure

```text
.
├── build.gradle
├── settings.gradle
├── README.md
├── data
│   └── input
│       └── user.json
└── src
    └── main
        ├── java
        │   └── project
        │       └── App.java
        └── resources
            └── application.properties
```

## API 목록

| 문제 | Method | Endpoint | 설명 |
|---|---|---|---|
| 문제 1 | GET | `/` | 서버 상태 확인 |
| 문제 2 | GET | `/sum` | 전체 유저의 게시물 수 합계 |
| 문제 3 | GET | `/sort/multiple` | 나이 오름차순, 게시물 수 내림차순 정렬 |
| 문제 4 | GET | `/users/analysis` | 필터링, 정렬, 그룹화 |

## Problem 1. 서버 상태 확인

### Request

```http
GET /
```

### Response

```json
{
  "message": "server check"
}
```

## Problem 2. 게시물 수 합계

### Request

```http
GET /sum
```

### Description

모든 유저의 `post_count` 값을 더합니다.

### Response

```json
{
  "sum": 108
}
```

위 숫자는 예시 데이터 기준입니다.

### Practice

- JSON 파일 읽기
- `List<Map<String, Object>>`
- 반복문을 활용한 합계 계산

## Problem 3. 다중 정렬

### Request

```http
GET /sort/multiple
```

### Description

다음 두 가지 조건으로 유저 목록을 정렬합니다.

1. `age` 오름차순
2. 나이가 같으면 `post_count` 내림차순

### Practice

- `stream()`
- `sorted()`
- `Comparator.comparingInt()`
- `thenComparing()`
- `reversed()`

## Problem 4. 필터링, 정렬, 그룹화 및 예외 처리

### Request

```http
GET /users/analysis
```

### Description

다음 조건을 만족하는 API를 구현합니다.

1. `data/input/user.json` 파일에서 유저 데이터를 읽어 옵니다.
2. `stream()`으로 유저 목록을 처리합니다.
3. `filter()`를 사용해 나이가 25세 이상인 유저만 선택합니다.
4. `sorted()`를 사용해 게시물 수(`post_count`)가 많은 순서대로 정렬합니다.
5. `Collectors.groupingBy()`를 사용해 나이(`age`)별로 유저를 그룹화합니다.
6. `Collectors.mapping()`을 사용해 각 그룹에 유저 이름(`name`)만 담습니다.
7. 정상 처리 시 HTTP `200 OK`와 그룹화된 결과를 반환합니다.
8. 예외 상황에 따라 적절한 HTTP 상태 코드와 오류 메시지를 반환합니다.

### Example Response

```json
{
  "25": ["Jung", "Kim"],
  "28": ["Choi"],
  "30": ["Lee"]
}
```

### Error Handling

| 상황 | HTTP Status | Error Message |
|---|---|---|
| JSON 파일이 없는 경우 | `404 Not Found` | `User data file not found` |
| JSON 형식이 잘못된 경우 | `400 Bad Request` | `Invalid user data format` |
| 필수 필드가 없거나 값이 잘못된 경우 | `400 Bad Request` | `Invalid user data fields` |
| 파일 읽기에 실패한 경우 | `500 Internal Server Error` | `Failed to read user data` |

### Example Error Response

```json
{
  "error": "User data file not found"
}
```

### Practice

- `stream()`
- `filter()`
- `sorted()`
- `Comparator.comparingInt()`
- `Collectors.groupingBy()`
- `Collectors.mapping()`
- `Collectors.toList()`
- `Files.exists()`
- `ObjectMapper`
- `try-catch`
- `ResponseEntity`
- `HttpStatus`

### Implementation Requirements

- 예외 처리에는 `try-catch`를 사용합니다.
- 파일이 없는 경우 `404 Not Found`를 반환합니다.
- JSON 파싱 오류와 필드 검증 오류는 `400 Bad Request`를 반환합니다.
- 파일 입출력 오류는 `500 Internal Server Error`를 반환합니다.
- 성공 응답과 오류 응답은 JSON 형식으로 반환합니다.
- 오류 응답에 내부 파일 경로나 스택 트레이스 등 민감한 정보를 포함하지 않습니다.

