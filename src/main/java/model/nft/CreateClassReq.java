package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreateClassReq {
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "class_id")
    private String classId;
    @JSONField(name = "symbol")
    private String symbol;
    @JSONField(name = "description")
    private String description;
    @JSONField(name = "uri")
    private String uri;
    @JSONField(name = "uri_hash")
    private String uriHash;
    @JSONField(name = "data")
    private String data;
    @JSONField(name = "owner")
    private String owner;
    @JSONField(name = "operation_id")
    private String operationId;
}
