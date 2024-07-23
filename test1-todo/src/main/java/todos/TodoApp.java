package todos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodoApp {
    TodoRepository todoRepository = new TodoRepository();
    ProjectRepository projectRepository = new ProjectRepository(todoRepository);

    public static void main(String[] args) throws Exception {
        new TodoApp().saveProject();
    }
    void saveProject(){
        Project project = new Project();
        project.setName("test project");
        project.setDescription("test desc");
        projectRepository.saveProject(project);
       List<TodoRequest> todoRequests = new ArrayList<>();
       todoRequests.add(new TodoRequest("task3","desc3",LocalDateTime.now(),false));

       project.setTodos(todoRequests);
    }

//        TodoServiceImp todoService = new TodoServiceImp();
//
//
//        TodoRequest newTodo = new TodoRequest();
//        newTodo.setTitle("Test1");
//        newTodo.setDescription("Write sql connection java");
//        newTodo.setStatus("Finished");
//        newTodo.setDueDate(LocalDateTime.now());
//        newTodo.setDone(true);
//
//
//        todoService.insert(newTodo);
//
//
//        List<TodoEntity> todos = todoService.selectAll();
//        for (TodoEntity todo : todos) {
//            System.out.println("Title: " + todo.getTitle() +
//                    " \nDescription: " + todo.getDescription() +
//                    " \nStatus: " + todo.getStatus() +
//                    " \nDue date: " + todo.getDueDate() +
//                    " \nIs done: " + todo.getDone() +
//                    " \nIs created at: " + todo.getCreatedAt() +
//                    " \nIs updated at: " + todo.getUpdateAt());
//            System.out.println();
//        }
//        System.out.println();
//        if (!todos.isEmpty()) {
//            TodoRequest updateTodo = new TodoRequest();
//            updateTodo.setTitle("Finish project (updated)");
//            updateTodo.setDescription("Complete the final project for the course (updated)");
//            updateTodo.setStatus("In Progress");
//            updateTodo.setDueDate(LocalDateTime.now().plusDays(3));
//            updateTodo.setDone(false);
//
//            todoService.update(todos.get(0).getId(), updateTodo);
//        }


    }

