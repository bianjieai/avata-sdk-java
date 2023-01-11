package model.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

@NoArgsConstructor
@Data
public class AccountResponse extends BaseResponse {

    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        private String account;
        private String name;
        private String operationId;
    }
}
