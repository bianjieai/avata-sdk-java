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

        @JSONField(name = "native_address")
        private String nativeAddress;// 原生地址格式

        @JSONField(name = "hex_address")
        private String hexAddress;// 以太坊地址格式

    }
}

