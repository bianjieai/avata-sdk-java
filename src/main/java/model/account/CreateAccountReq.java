package model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreateAccountReq {

    @JSONField(name = "name")
    private String name;
    @JSONField(name = "operation_id")
    private String operationId;
}
