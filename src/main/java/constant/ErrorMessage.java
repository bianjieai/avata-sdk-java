package constant;

public enum ErrorMessage {

    UNKNOWN_ERROR(9999, "unknown error"),
    INTERNAL_ERROR(500, "internal error")
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

    public static String getMessage(Integer code) {
        for (ErrorMessage error : ErrorMessage.values()) {
            if (error.code.equals(code)) {
                return error.message;
            }
        }
        return null;
    }

    public static String getMessage(ErrorMessage errorMessage) {
        for (ErrorMessage error : ErrorMessage.values()) {
            if (error.code.equals(errorMessage.code)) {
                return error.message;
            }
        }
        return null;
    }

}
