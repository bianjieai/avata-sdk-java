package model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BatchCreateAccountReq {

    @JSONField(name = "count")
    private Integer count;
    @JSONField(name = "operation_id")
    private String operationId;
}
