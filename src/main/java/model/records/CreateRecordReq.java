package model.records;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreateRecordReq {

    @JSONField(name = "identity_type")
    private Integer identityType;
    @JSONField(name = "identity_name")
    private String identityName;
    @JSONField(name = "identity_num")
    private String identityNum;
    @JSONField(name = "type")
    private Integer type;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "description")
    private String description;
    @JSONField(name = "hash")
    private String hash;
    @JSONField(name = "hash_type")
    private Integer hashType;
    @JSONField(name = "operation_id")
    private String operationId;
}
