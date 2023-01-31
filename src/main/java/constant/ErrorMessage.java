package constant;

public enum ErrorMessage {
    AVATA_ERROR(-1, "avata error"),
    UNKNOWN_ERROR(-1, "unknown error"),
    INTERNAL_ERROR(-1, "internal error"),
    OPERATION_ID_ERROR(-1, "operation_id is required"),
    NAME_ERROR(-1, "name is required"),
    TYPE_ERROR(-1, "type is required"),
    HASH_TYPE_ERROR(-1, "hash_type is required"),
    HASH_ERROR(-1, "hash is required"),
    DESCRIPTION_ERROR(-1, "description is required"),
    ORDER_ID_ERROR(-1, "order_id is required"),
    AMOUNT_ERROR(-1, "amount is required"),
    ACCOUNT_ERROR(-1, "account is required"),
    ORDER_TYPE_ERROR(-1, "order_type is required"),
    ORDER_LIST_ERROR(-1, "list is required"),
    OWNER_ERROR(-1, "owner is required"),
    RECIPIENT_ERROR(-1, "recipient is required"),
    DATA_ERROR(-1, "data is required"),
    API_KEY_ERROR(-1, "api_key is required"),
    API_SECRET_ERROR(-1, "api_secret is required"),
    DOMAIN_ERROR(-1, "domain is required"),
    HTTP_TIMEOUT_ERROR(-1, "http timeout can not less than 0"),
    REQUEST_TIMEOUT_ERROR(-1, "request timeout");

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
