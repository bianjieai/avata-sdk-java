package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Data
public class EditNftReq {
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "uri")
    private String uri;
    @JSONField(name = "data")
    private String data;
    @JSONField(name = "operation_id")
    private String operationId;
    @JSONField(name = "tag")
    private Map<String, Object> tag;

}
