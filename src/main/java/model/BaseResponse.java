package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BaseResponse {
    private int code;
    private String message;

    @NoArgsConstructor
    @Data
    public static class Http {
        private Integer code;
        private String message;
    }
}

