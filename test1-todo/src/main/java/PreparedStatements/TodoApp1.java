package PreparedStatements;

import org.todo.test.TodoData;
import org.todo.test.TodoImp;
import org.todo.test.TodoImplements;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TodoApp1 {
    public static void main(String[] args) {
        TodoImp todoDAO = new TodoImplements();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("ToDo Application");
            System.out.println("1. Create ToDo");
            System.out.println("2. List ToDos");
            System.out.println("3. Update ToDo");
            System.out.println("4. Delete ToDo");
            System.out.println("e. Exit");
            System.out.print("Choose an option: ");
            char choice = scanner.nextLine().charAt(0);
            scanner.nextLine();

            switch (choice) {
                case '1':
                    createTodo(todoDAO, scanner);
                    break;
                case '2':
                    listTodos(todoDAO);
                    break;
                case '3':
                    updateTodo(todoDAO, scanner);
                    break;
                case '4':
                    deleteTodo(todoDAO, scanner);
                    break;
                case 'e':
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void createTodo(TodoImp todoDAO, Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter status: ");
        String status = scanner.nextLine();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());
        TodoData newTodo = new TodoData(title, description, status, dueDate);
        todoDAO.create(newTodo);
    }

    private static void listTodos(TodoImp todoDAO) {
        List<TodoData> todos = todoDAO.getAll();
        for (TodoData todo : todos) {
            System.out.println("ID: " + todo.getId());
            System.out.println("Title: " + todo.getTitle());
            System.out.println("Description: " + todo.getDescription());
            System.out.println("Status: " + todo.getStatus());
            System.out.println("Due Date: " + todo.getDueDate());
            System.out.println("------");
        }
    }

    private static void updateTodo(TodoImp todoDAO, Scanner scanner) {
        System.out.print("Enter ID of the ToDo to update: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new description: ");
        String newDescription = scanner.nextLine();
        System.out.print("Enter new status: ");
        String newStatus = scanner.nextLine();
        System.out.print("Enter new due date (YYYY-MM-DD): ");
        LocalDate newDueDate = LocalDate.parse(scanner.nextLine());
        TodoData updatedTodo = new TodoData(idToUpdate, newTitle, newDescription, newStatus, newDueDate);
        todoDAO.update(updatedTodo);
    }

    private static void deleteTodo(TodoImp todoDAO, Scanner scanner) {
        System.out.print("Enter ID of the ToDo to delete: ");
        int idToDelete = scanner.nextInt();
        todoDAO.delete(idToDelete);
    }
}
