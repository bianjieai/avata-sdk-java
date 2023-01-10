package model.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

@NoArgsConstructor
@Data
public class AccountResponse extends BaseResponse {

    private DataDTO data;

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        private String account;
        private String name;
        private String operationId;

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOperationId() {
            return operationId;
        }

        public void setOperationId(String operationId) {
            this.operationId = operationId;
        }
    }
}
