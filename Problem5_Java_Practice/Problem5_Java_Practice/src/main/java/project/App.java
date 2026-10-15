package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @RestController
    @RequestMapping("/api/posts")
    public static class PostController {

        // 연습용 게시물 데이터입니다.
        // 실제 Problem5의 JavaScript 테스트와는 무관한 별도 Java 구현입니다.
        private final List<Map<String, Object>> posts = new ArrayList<>(List.of(
            Map.of("id", 1, "title", "Spring 입문", "authorId", 5, "authorName", "민수"),
            Map.of("id", 2, "title", "Java 컬렉션 정리", "authorId", 10, "authorName", "지우"),
            Map.of("id", 3, "title", "REST API 만들기", "authorId", 5, "authorName", "민수"),
            Map.of("id", 4, "title", "테스트 코드 작성", "authorId", 20, "authorName", "서연"),
            Map.of("id", 5, "title", "게시물 필터링", "authorId", 10, "authorName", "지우")
        ));

        private final List<Map<String, Object>> authors = List.of(
            Map.of("id", 5, "name", "민수"),
            Map.of("id", 10, "name", "지우"),
            Map.of("id", 20, "name", "서연"),
            Map.of("id", 100, "name", "하늘")
        );

        // TODO 1: 모든 게시물 목록을 반환하세요.
        @GetMapping
        public ResponseEntity<?> getPosts(
                @RequestParam(required = false) String authorId) {

            // TODO: authorId가 없거나 "all"이면 모든 게시물을 반환
            // TODO: 특정 authorId가 있으면 해당 작성자의 게시물만 반환
            // TODO: 현재는 모든 게시물을 반환하는 기본 동작입니다.
            return ResponseEntity.ok(posts);
        }

        // TODO 2: 작성자 목록을 반환하세요.
        @GetMapping("/authors")
        public ResponseEntity<?> getAuthors() {
            // TODO: 과제 화면의 요구사항에 맞춰 작성자 목록을 반환하세요.
            return ResponseEntity.ok(authors);
        }
    }
}
