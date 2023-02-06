package model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ErrorResponse {

    private ErrorDTO error;

    @NoArgsConstructor
    @Data
    public static class ErrorDTO {
        @JSONField(name = "code")
        private String code;
        @JSONField(name = "code_space")
        private String codeSpace;
        @JSONField(name = "message")
        private String message;
    }
}
