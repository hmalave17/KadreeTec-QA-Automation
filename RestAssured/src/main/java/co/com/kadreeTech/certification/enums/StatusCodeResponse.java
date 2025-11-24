package co.com.kadreeTech.certification.enums;

public enum StatusCodeResponse {

    SUCCESSFUL(200),
    INTERNAL_ERROR_SERVER(500)

    ;
    private Integer StatusCode;
    StatusCodeResponse(Integer statusCode){
        this.StatusCode = statusCode;
    }

    public Integer getStatusCode() {
        return StatusCode;
    }
}
