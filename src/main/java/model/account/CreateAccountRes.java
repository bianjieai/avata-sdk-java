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
        private String account;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "operation_id")
        private String operationId;
    }
}
