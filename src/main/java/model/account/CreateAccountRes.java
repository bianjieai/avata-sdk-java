package model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

@NoArgsConstructor
@Data
public class CreateAccountRes extends BaseResponse {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "account")
        private String account;// 链账户地址
        @JSONField(name = "name")
        private String name;// 链账户名称
        @JSONField(name = "operation_id")
        private String operationId;// 操作 ID。此操作 ID 仅限在查询链账户接口中使用，用于查询创建链账户的授权状态。
    }
}
