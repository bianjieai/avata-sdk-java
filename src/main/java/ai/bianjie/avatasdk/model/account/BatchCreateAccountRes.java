package ai.bianjie.avatasdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;
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

        @JSONField(name = "accounts")
        private List<String> accounts;// 链账户地址列表
    }
}
