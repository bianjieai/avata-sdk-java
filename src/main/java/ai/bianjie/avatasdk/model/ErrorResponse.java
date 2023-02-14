package ai.bianjie.avatasdk.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ErrorResponse {

    private AvataError error;

    @NoArgsConstructor
    @Data
    public static class AvataError {
        @JSONField(name = "code")
        private String code;
        @JSONField(name = "code_space")
        private String codeSpace;
        @JSONField(name = "message")
        private String message;
    }
}
