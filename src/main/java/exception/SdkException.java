package exception;

import constant.ErrorMessage;
import model.ErrorResponse;

public class SdkException extends RuntimeException {
    private final ErrorResponse.ErrorDTO error;
    private final int code;
    private final String msg;

    public SdkException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.error = null;
        this.code = errorMessage.getCode();
        this.msg = errorMessage.getMessage();
    }

    public SdkException(int code, String msg, ErrorResponse.ErrorDTO error) {
        super(msg);
        this.error = error;
        this.code = code;
        this.msg = msg;
    }

    public ErrorResponse.ErrorDTO getError() {
        return error;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
