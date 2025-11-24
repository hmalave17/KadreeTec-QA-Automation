package co.com.kadreeTech.certification.utils;

public class ConstantsExcel {

    /**
     * Search data excel
     */
    public static final String PATH_FILE = "./src/test/resources/data/dataTestFile.xlsx";
    public static final String QUERY_EXCEL = "select * from  %s where idTest =  %s";

    /***
     *Name of value at the table
     */
    public static final String CHECK_IN = "checkin";
    public static final String CHECK_OUT = "checkout";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String TOTAL_PRICE = "totalprice";
    public static final String ADDITIONAL_NEEDS = "additionalneeds";
    public static final String DEPOSIT_PAID = "depositpaid";
    public static final String TRUE_VALUE = "1";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    /****
     *Name of sheet at the file
     */
    public static final String SHEET_SUCCESSFUL = "CreateBookingSuccessful";
    public static final String SHEET_FAILED = "CreateBookingFailed";
    public static final String SHEET_UPDATE_BOOKING = "UpdateBooking";

    /****
     *Number idTest
     */
    public static final String CREATE_BOOKING_SUCCESSFUL = "1";

    public ConstantsExcel() {
    }
}
