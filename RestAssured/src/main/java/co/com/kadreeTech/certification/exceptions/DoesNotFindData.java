package co.com.kadreeTech.certification.exceptions;

public class DoesNotFindData extends AssertionError {

    public static final String NOT_DATA = "Doesn't find data";

    public DoesNotFindData(){
        super(NOT_DATA);
    }
}
