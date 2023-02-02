package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class BatchCreateNftReq {
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "uri")
    private String uri;
    @JSONField(name = "uri_hash")
    private String uriHash;
    @JSONField(name = "data")
    private String data;
    @JSONField(name = "recipients")
    private List<RecipientsDTO> recipients;
    @JSONField(name = "operation_id")
    private String operationId;

    @NoArgsConstructor
    @Data
    public static class RecipientsDTO {
        @JSONField(name = "amount")
        private Integer amount;
        @JSONField(name = "recipient")
        private String recipient;
    }
}
