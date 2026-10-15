package project.todo;

public class TodoRepository{

    private final List<Todo> todos = new ArrayList<>();

    public void save(Todo todo){
        todos.add(todo);
    }

    public List<Todo> findAll(){
        return new ArrayList<>(todos);
    }

    public Optional<Todo> findById(long id){
        return todos.stream()
                .filter(todo -> todo.id() == id)
                .findFirst();
    }

    public boolean deleteById(long id){
        return todos.removeIf(todo -> todo.id() == id);
    }
}