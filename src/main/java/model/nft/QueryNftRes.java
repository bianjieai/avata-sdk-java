package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

@NoArgsConstructor
@Data
public class QueryNftRes extends BaseResponse {

    @JSONField(name = "data")
    private DataDTO data;
    @NoArgsConstructor
    @Data
    public static class DataDTO {

        @JSONField(name = "id")
        private String id;

        @JSONField(name = "name")
        private String name;

        @JSONField(name = "class_id")
        private String classId;

        @JSONField(name = "class_name")
        private String className;

        @JSONField(name = "class_symbol")
        private String classSymbol;

        @JSONField(name = "uri")
        private String uri;

        @JSONField(name = "uri_hash")
        private String uriHash;

        @JSONField(name = "data")
        private String data;

        @JSONField(name = "owner")
        private String owner;

        @JSONField(name = "status")
        private String status;

        @JSONField(name = "tx_hash")
        private String txHash;

        @JSONField(name = "timestamp")
        private String timestamp;
    }
}
