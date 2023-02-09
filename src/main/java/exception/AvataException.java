package exception;

import lombok.Data;
import model.ErrorResponse;

/**
 * SDK custom exception
 *
 * @author sxj
 */
@Data
public class AvataException extends RuntimeException {
    private static final String CodeSpace = "AVATA-SDK-JAVA";
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

    private final String codeSpace;
    private final String code;
    private final String message;

    public AvataException(String code, String codeSpace, String message) {
        super(message);
        this.codeSpace = codeSpace;
        this.message = message;
        this.code = code;
    }

    public static AvataException NewSDKException(String errorMessage) {
        return new AvataException(UnknownError, CodeSpace, errorMessage);
    }

    public static AvataException NewHTTPException(ErrorResponse.AvataError avataError) {
        return new AvataException(avataError.getCode(), avataError.getCodeSpace(), avataError.getMessage());
    }

    public static AvataException InvalidParamException(String errorMessage) {
        return new AvataException(BadRequest, CodeSpace, errorMessage);
    }

    public static AvataException TimeOutException() {
        return new AvataException(TimeoutError, CodeSpace, "request timeout");
    }

}
