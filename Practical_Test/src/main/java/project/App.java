
package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    // 문제 1: 서버 확인
    @GetMapping("/")
    public Map<String, String> check() {
        return Map.of("message", "server check");
    }

    // 문제 2: 게시물 수 총합
    @GetMapping("/sum")
    public Map<String, Integer> countPost() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Path path = Path.of("data/input/user.json");

        if (!Files.exists(path)) {
            path = Path.of("../data/input/user.json");
        }

        List<Map<String, Object>> users = mapper.readValue(
                path.toFile(),
                new TypeReference<List<Map<String, Object>>>() {}
        );

        int sum = 0;

        for (int i = 0; i < users.size(); i++) {
            sum += ((Number) users.get(i).get("post_count")).intValue();
        }

        return Map.of("sum", sum);
    }

    // 문제 3: 나이 오름차순, 게시물 수 내림차순
    @GetMapping("/sort/multiple")
    public List<Map<String, Object>> sortMultiple() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Path path = Path.of("data/input/user.json");

        if (!Files.exists(path)) {
            path = Path.of("../data/input/user.json");
        }

        List<Map<String, Object>> users = mapper.readValue(
                path.toFile(),
                new TypeReference<List<Map<String, Object>>>() {}
        );

        List<Map<String, Object>> result = users.stream()
                .sorted(Comparator.comparingInt(
                                user -> ((Number)user.get("age")).intValue())
                        .thenComparing(Comparator.comparingInt(
                                user -> ((Number)user.get("post_count")).intValue()).reversed()
                        )
                )
                .toList();

        return result;
    }

    // 문제 4: 필터링, 정렬, 그룹화 및 예외 처리
    @GetMapping("/users/analysis")
    public ResponseEntity<?> analyzeUsers() {
        Path path = Path.of("data/input/user.json");

        if (!Files.exists(path)) {
            path = Path.of("../data/input/user.json");
        }

        // 1. 파일 존재 여부 확인
        if (!Files.exists(path)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "User data file not found"));
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            // 2. 파일 읽기
            String json = Files.readString(path);

            // 3. JSON 구조 및 필드 검증
            JsonNode root = mapper.readTree(json);

            if (root == null || !root.isArray()) {
                return ResponseEntity.badRequest()
                        .body(Map.of("error", "Invalid user data format"));
            }

            Set<String> requiredFields = Set.of(
                    "id", "name", "post_count", "age"
            );

            for (JsonNode user : root) {
                if (!user.isObject()) {
                    return ResponseEntity.badRequest()
                            .body(Map.of("error", "Invalid user data fields"));
                }

                Set<String> actualFields = new HashSet<>();
                user.fieldNames().forEachRemaining(actualFields::add);

                if (!actualFields.containsAll(requiredFields)
                        || !user.get("id").canConvertToInt()
                        || !user.get("name").isTextual()
                        || !user.get("post_count").isIntegralNumber()
                        || !user.get("age").isIntegralNumber()
                        || !user.get("post_count").canConvertToInt()
                        || !user.get("age").canConvertToInt()
                        || user.get("post_count").intValue() < 0
                        || user.get("age").intValue() < 0) {

                    return ResponseEntity.badRequest()
                            .body(Map.of("error", "Invalid user data fields"));
                }
            }

            // 4. JSON을 Java 객체로 변환
            List<Map<String, Object>> users = mapper.readValue(
                    json,
                    new TypeReference<List<Map<String, Object>>>() {}
            );

            // 5. 필터링, 정렬, 그룹화
            Map<Integer, List<String>> result = users.stream()
                    .filter(user ->
                            ((Number) user.get("age")).intValue() >= 25
                    )
                    .sorted(
                            Comparator.comparingInt(
                                    (Map<String, Object> user) ->
                                            ((Number) user.get("post_count")).intValue()
                            ).reversed()
                    )
                    .collect(Collectors.groupingBy(
                            user -> ((Number) user.get("age")).intValue(),
                            Collectors.mapping(
                                    user -> (String) user.get("name"),
                                    Collectors.toList()
                            )
                    ));

            // 6. 정상 응답
            return ResponseEntity.ok(result);

        } catch (JsonProcessingException e) {
            // JSON 파싱 오류
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Invalid user data format"));

        } catch (IOException e) {
            // 파일 읽기 오류
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Failed to read user data"));
        }
    }
}
