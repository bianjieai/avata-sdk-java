package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DeleteNftReq {
    @JSONField(name = "operation_id")
    private String operationId;
}
