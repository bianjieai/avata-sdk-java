package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

@NoArgsConstructor
@Data
public class QueryClassRes extends BaseResponse {
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "id")
        private String id;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "symbol")
        private String symbol;
        @JSONField(name = "description")
        private String description;
        @JSONField(name = "nft_count")
        private Integer nftCount;
        @JSONField(name = "uri")
        private String uri;
        @JSONField(name = "uri_hash")
        private String uriHash;
        @JSONField(name = "data")
        private String data;
        @JSONField(name = "owner")
        private String owner;
        @JSONField(name = "tx_hash")
        private String txHash;
        @JSONField(name = "timestamp")
        private String timestamp;
    }
}
