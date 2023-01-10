package exception;

import constant.ErrorMessage;

public class SdkException extends RuntimeException {
    private final String codeSpace;
    private final int code;
    private final String msg;

    public SdkException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.codeSpace = errorMessage.getCodeSpace();
        this.code = errorMessage.getCode();
        this.msg = errorMessage.getMessage();
    }

    public SdkException(String codeSpace, int code, String msg) {
        super(msg);
        this.codeSpace = codeSpace;
        this.code = code;
        this.msg = msg;
    }

    public String getCodeSpace() {
        return codeSpace;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
