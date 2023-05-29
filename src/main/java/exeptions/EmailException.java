package exeptions;

public class EmailException extends Exception{

    public EmailException (String message){
        super(message);
    }

    public EmailException (){}

    @Override
    public String toString() {
        return "Email should contain @ symbol";
    }
}
