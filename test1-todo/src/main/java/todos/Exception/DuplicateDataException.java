package todos.Exception;

public class DuplicateDataException extends RuntimeException{
    public DuplicateDataException (String message){
        super(message);
    }
}
