package co.com.kadreeTech.certification.exceptions;

public class UnexpectedBodyResponse extends Exception{
    public static final String UNEXPECTED_BODY_RESPONSE = "Unexpected body response";
    public UnexpectedBodyResponse(String message, Throwable cause){
        super(message, cause);
    }
}
