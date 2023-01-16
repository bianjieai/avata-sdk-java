package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Data
public class EditMtReq {

    @JSONField(name = "data")
    private String data;
    @JSONField(name = "tag")
    private Map<String, Object> tag;
    @JSONField(name = "operation_id")
    private String operationId;
}
