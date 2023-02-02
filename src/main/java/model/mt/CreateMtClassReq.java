package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreateMtClassReq {

    @JSONField(name = "name")
    private String name;
    @JSONField(name = "owner")
    private String owner;
    @JSONField(name = "data")
    private String data;
    @JSONField(name = "operation_id")
    private String operationId;
}
