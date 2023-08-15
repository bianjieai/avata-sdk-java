package ai.bianjie.avatasdk.exception;

import lombok.Data;
import ai.bianjie.avatasdk.model.ErrorResponse;

/**
 * SDK custom ai.bianjie.avatasdk.exception
 */
@Data
public class AvataException extends RuntimeException {
    private static final String CodeSpace = "AVATA-SDK";
    private static final String BadRequest = "BAD_REQUEST";
    private static final String UnknownError = "UNKNOWN_ERROR";
    private static final String TimeoutError = "TIMEOUT_ERROR";

    public static final String PARAM_ERROR = "%s is required";
    public static final String HTTP_TIMEOUT_ERROR = "http timeout can not less than 0";
    public static final String REQUEST_TIMEOUT_ERROR = "request timeout";
    public static final String ErrDomain = "the avata domain address is required";
    public static final String ErrAPIKey = "the api key for the project is required";
    public static final String ErrAPISecret = "the api secret the project is required";
    public static final String ErrAmount = "amount should be integer yuan";

    private final String codeSpace; // 命名空间
    private final String code; // 错误码
    private final String message; // 错误描述

    public AvataException(String code, String codeSpace, String message) {
        super(message);
        this.codeSpace = codeSpace;
        this.message = message;
        this.code = code;
    }

    // 来自 Avata SDK 返回的报错信息
    public static AvataException NewSDKException(String errorMessage) {
        return new AvataException(UnknownError, CodeSpace, errorMessage);
    }

    // 来自 Avata OPEN API 返回的报错信息
    public static AvataException NewClientException(ErrorResponse.AvataError avataError) {
        return new AvataException(avataError.getCode(), avataError.getCodeSpace(), avataError.getMessage());
    }

    // 来自 Avata SDK 返回的报错信息，必填参数校验
    public static AvataException InvalidParamException(String errorMessage) {
        return new AvataException(BadRequest, CodeSpace, errorMessage);
    }

    // 来自 Avata SDK 返回的报错信息，HTTP 连接超时报错
    public static AvataException TimeOutException() {
        return new AvataException(TimeoutError, CodeSpace, "request timeout");
    }
}
