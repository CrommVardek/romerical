package romerical;

public class NotARomanNumberException extends RuntimeException {

    public NotARomanNumberException(String message){
        super(message);
    }

    public NotARomanNumberException() { super("Not a roman number"); }

}
