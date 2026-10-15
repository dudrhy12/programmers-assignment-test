package project.todo.service;

import project.todo.domain.Todo;
import project.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {

    private final TodoRepository repository;
    private final AtomicLong idGenerator = new AtomicLong(1);

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo addTodo(String text) {
        Todo todo = new Todo(
                idGenerator.getAndIncrement(),
                text
        );

        return repository.save(todo);
    }

    public List<Todo> getTodos() {
        return repository.findAll();
    }

    public boolean deleteTodo(long id) {
        return repository.deleteById(id);
    }
}