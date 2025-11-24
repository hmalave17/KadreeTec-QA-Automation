package co.com.kadreeTech.certification.exceptions;

public class UnexpectedStatusCode extends Exception{
    public static final String UNEXPECTED_STATUS_CODE = "Unexpected status code";
    public UnexpectedStatusCode(String message, Throwable cause){
        super(message, cause);
    }
}
