package ai.bianjie.avatasdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建链账户正确返回值
 */
@NoArgsConstructor
@Data
public class CreateAccountRes {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {

        @JSONField(name = "account")
        private String account; // 链账户地址
    }
}
