package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Data
public class CreateMtReq {

    @JSONField(name = "data")
    private String data;
    @JSONField(name = "amount")
    private Integer amount;
    @JSONField(name = "recipient")
    private String recipient;
    @JSONField(name = "tag")
    private Map<String, Object> tag;
    @JSONField(name = "operation_id")
    private String operationId;
}
