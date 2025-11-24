package co.com.kadreeTech.certification.exceptions;

public class UnexpectedSchemasResponse extends Exception{
    public static final String UNEXPECTED_SCHEMAS_RESPONSE = "Unexpected schemas response";
    public UnexpectedSchemasResponse(String message, Throwable cause){
        super(message, cause);
    }
}
