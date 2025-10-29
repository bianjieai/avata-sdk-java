package ai.bianjie.avatasdk.model.account;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 批量创建链账户正确返回值
 */
@NoArgsConstructor
@Data
public class BatchCreateAccountRes {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {

        @JSONField(name = "addresses")
        private List<AccountsDTO> addresses;// 链账户地址列表

        @NoArgsConstructor
        @Data
        public static class AccountsDTO {

            @JSONField(name = "native_address")
            private String nativeAddress;// 原生地址格式

            @JSONField(name = "hex_address")
            private String hexAddress;// 以太坊地址格式

        }
    }
}
