package ai.bianjie.avatasdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
        @JSONField(name = "operation_id")
        private String operationId;// 操作 ID。此操作 ID 仅限在查询链账户接口中使用，用于查询创建链账户的授权状态。
    }
}
