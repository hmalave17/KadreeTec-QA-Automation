package co.com.kadreeTech.certification.exceptions;

public class NotMatchKey extends Exception{
    public static final String NOT_MATCH_KEY = "No matching key found for updateParameter: ";
    public NotMatchKey(String message, Throwable cause){
        super(message, cause);
    }
}
