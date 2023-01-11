package model.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.List;

@NoArgsConstructor
@Data
public class QueryAccountsRes extends BaseResponse {

    private QueryAccountsHistoryRes.DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        private Integer offset;
        private Integer limit;
        private Integer totalCount;
        private List<AccountsDTO> accounts;

        @NoArgsConstructor
        @Data
        public static class AccountsDTO {
            private String account;
            private String name;
            private Integer gas;
            private Integer bizFee;
            private String operationId;
            private Integer status;
        }
    }
}
