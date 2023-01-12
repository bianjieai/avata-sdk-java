package constant;

public enum ErrorMessage {
    AVATA_ERROR(-1, "avata error"),
    UNKNOWN_ERROR(-1, "unknown error"),
    INTERNAL_ERROR(-1, "internal error"),
    OPERATION_ID_ERROR(-1, "operation_id is required"),
    NAME_ERROR(-1, "name is required"),
    OWNER_ERROR(-1,"owner is required"),

    RECIPIENT_ERROR(-1,"recipient is required"),
    API_KEY_ERROR(-1, "api_key is required"),
    API_SECRET_ERROR(-1, "api_secret is required"),
    DOMAIN_ERROR(-1, "domain is required"),
    HTTP_TIMEOUT_ERROR(-1, "http timeout can not less than 0")
    ;

    private Integer code;
    private String message;

    private ErrorMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public Integer getCode() {
        return code;
    }

}
