package Factory;

public class InvalidBankException extends RuntimeException{
    public InvalidBankException(String message){
        super(message);
    }
}
