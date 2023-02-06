package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DeleteMtReq {

    @JSONField(name = "amount")
    private Integer amount;
    @JSONField(name = "operation_id")
    private String operationId;
}
