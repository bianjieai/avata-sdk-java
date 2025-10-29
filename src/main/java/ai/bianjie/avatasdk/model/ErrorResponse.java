package ai.bianjie.avatasdk.model;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ErrorResponse {

    private AvataError error;

    @NoArgsConstructor
    @Data
    public static class AvataError {
        @JSONField(name = "code_space")
        private String codeSpace; // 命名空间
        @JSONField(name = "code")
        private String code;// 错误码
        @JSONField(name = "message")
        private String message;// 错误描述
    }
}
