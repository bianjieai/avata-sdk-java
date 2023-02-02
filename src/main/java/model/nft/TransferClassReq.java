package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Data
public class TransferClassReq {
    @JSONField(name = "recipient")
    private String recipient;

    @JSONField(name = "operation_id")
    private String operationId;

}