package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @RestController
    public static class TodoController {

        // TODO: 할 일 데이터를 저장할 자료구조를 선언하세요.
        // 예: List<Map<String, Object>> todos = new ArrayList<>();

        // TODO 1: 할 일 생성 API를 구현하세요.
        // @PostMapping("문제 안내문에 나온 경로")
        // 요청 본문을 받으려면 @RequestBody를 사용할 수 있습니다.

        // TODO 2: 할 일 전체 조회 API를 구현하세요.
        // @GetMapping("문제 안내문에 나온 경로")

        // TODO 3: 할 일 삭제 API를 구현하세요.
        // @DeleteMapping("문제 안내문에 나온 경로")
    }
}
