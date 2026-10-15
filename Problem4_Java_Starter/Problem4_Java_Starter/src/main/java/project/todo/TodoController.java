package project.todo.controller;

import project.todo.domain.Todo;
import project.todo.dto.TodoRequest;
import project.todo.service.TodoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    // 할 일 생성
    @PostMapping
    public ResponseEntity<Todo> addTodo(
            @RequestBody TodoRequest request
    ) {
        Todo todo = service.addTodo(request.text());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todo);
    }

    // 할 일 목록 조회
    @GetMapping
    public List<Todo> getTodos() {
        return service.getTodos();
    }

    // 할 일 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTodo(
            @PathVariable long id
    ) {
        boolean deleted = service.deleteTodo(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                Map.of("message", "Todo deleted")
        );
    }
}