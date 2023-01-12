package model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.List;

@NoArgsConstructor
@Data
public class QueryAccountsRes extends BaseResponse {

    @JSONField(name = "data")
    private QueryAccountsHistoryRes.DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "offset")
        private Integer offset;
        @JSONField(name = "limit")
        private Integer limit;
        @JSONField(name = "total_count")
        private Integer totalCount;
        @JSONField(name = "accounts")
        private List<AccountsDTO> accounts;

        @NoArgsConstructor
        @Data
        public static class AccountsDTO {
            @JSONField(name = "account")
            private String account;
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "gas")
            private Integer gas;
            @JSONField(name = "biz_fee")
            private Integer bizFee;
            @JSONField(name = "operation_id")
            private String operationId;
            @JSONField(name = "status")
            private Integer status;
        }
    }
}
