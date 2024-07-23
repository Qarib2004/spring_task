//package todos;
//
//import java.util.List;
//
//public class TodoService {
//    private final TodoRepository todoRepository;
//
//    public TodoService() {
//        this.todoRepository = new TodoServiceImp();
//    }
//
//    public void insert(TodoRequest todoRequest) {
//        todoRepository.insert(todoRequest);
//    }
//
//    public void update(int id, TodoRequest todoRequest) {
//        todoRepository.update(id, todoRequest);
//    }
//
//    public TodoEntity select(int id) {
//        return todoRepository.select(id);
//    }
//
//    public List<TodoEntity> selectAll() {
//        return todoRepository.selectAll();
//    }
//
//    public void delete(int id) {
//        todoRepository.delete(id);
//    }
//}
