package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ErrorResponse {

    private ErrorDTO error;

    @NoArgsConstructor
    @Data
    public static class ErrorDTO {
        private String code;
        private String codeSpace;
        private String message;
    }
}
