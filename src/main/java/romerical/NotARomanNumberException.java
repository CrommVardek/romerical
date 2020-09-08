package romerical;

public class NotARomanNumberException extends RuntimeException {

    public NotARomanNumberException(String message){
        super("Not a roman number " + message);
    }

}
