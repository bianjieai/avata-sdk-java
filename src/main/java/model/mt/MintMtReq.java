package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MintMtReq {

    @JSONField(name = "amount")
    private Integer amount;
    @JSONField(name = "recipient")
    private String recipient;
    @JSONField(name = "operation_id")
    private String operationId;
}
