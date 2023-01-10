package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ErrorResponse {

    private ErrorDTO error;

    public ErrorDTO getError() {
        return error;
    }

    public void setError(ErrorDTO error) {
        this.error = error;
    }

    @NoArgsConstructor
    @Data
    public static class ErrorDTO {
        private String code;
        private String codeSpace;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCodeSpace() {
            return codeSpace;
        }

        public void setCodeSpace(String codeSpace) {
            this.codeSpace = codeSpace;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
