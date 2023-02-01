package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Data
public class DeleteNftReq {
    @JSONField(name = "operation_id")
    private String operationId;
    @JSONField(name = "tag")
    private Map<String, Object> tag;

}
