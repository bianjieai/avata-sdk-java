package model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class QueryAccountsRes {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "offset")
        private Integer offset;// 游标
        @JSONField(name = "limit")
        private Integer limit;// 每页记录数
        @JSONField(name = "total_count")
        private Integer totalCount;// 总记录数
        @JSONField(name = "accounts")
        private List<AccountsDTO> accounts;// 链账户列表

        @NoArgsConstructor
        @Data
        public static class AccountsDTO {
            @JSONField(name = "account")
            private String account;// 链账户地址
            @JSONField(name = "name")
            private String name;// 链账户名称
            @JSONField(name = "gas")
            private Integer gas;// 文昌链能量值余额
            @JSONField(name = "biz_fee")
            private Integer bizFee;// 文昌链 DDC 业务费余额，单位：分
            @JSONField(name = "operation_id")
            private String operationId;// 操作 ID
            @JSONField(name = "status")
            private Integer status;// Enum: 0，1；链账户的授权状态，0 未授权；1 已授权。链账户授权成功后，可使用该链账户地址发起上链交易请求；未授权时不影响作为交易的接受者地址进行使用（DDC 业务除外）。
        }
    }
}
