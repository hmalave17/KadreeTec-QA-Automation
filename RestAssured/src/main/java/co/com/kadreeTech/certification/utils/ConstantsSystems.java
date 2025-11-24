package co.com.kadreeTech.certification.utils;

public class ConstantsSystems {

    /**
     * URL base and resource
     */
    public static final String URL_BASE = ParameterReader.getProperty("endpoint.url.base");
    public static final String RESOURCE_CREATE_BOOKING = ParameterReader.getProperty("endpoint.createBooking");
    public static final String RESOURCE_GET_BOOKING = ParameterReader.getProperty("endpoint.getBooking");
    public static final String RESOURCE_CREATE_TOKEN= ParameterReader.getProperty("endpoint.createToken");

    /**
     * Keywords
     */
    public static final String STATUS_CODE = "status code";
    public static final String APPLICATION_JSON = "application/json";
    public static final String COOKIE = "Cookie";
    public static final String TOKEN_HEADER = "token=";
    public static final String RESOURCE_BOOKING_UPDATE = "resource-booking-update";


    /***
     * Path resource
     */
    public static final String PATH_SCHEMA_CREATE_BOOKING = "schemas/create_booking_schemas.json";
    public static final String PATH_SCHEMA_CREATE_TOKEN = "schemas/create_token_schemas.json";
    public static final String PATH_SCHEMA_UPDATE_BOOKING = "schemas/update_booking_schemas.json";

    /**
     * Path response
     */
    public static final String PATH_BOOKING = "[%s].bookingid";
    public static final String PATH_TOKEN = "token";
    public static final String PATH_BOOKING_ID = "bookingid";

    public ConstantsSystems(){}

}
