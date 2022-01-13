package myownexception;

public class AccountInvalidOwnException extends RuntimeException{
    public AccountInvalidOwnException(String message){
        super(message);

    }
}
