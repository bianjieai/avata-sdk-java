package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.List;

@NoArgsConstructor
@Data
public class QueryNftsRes extends BaseResponse {
    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "offset")
        private Integer offset;

        @JSONField(name = "limit")
        private Integer limit;

        @JSONField(name = "total_count")
        private Integer totalCount;

        @JSONField(name = "nfts")
        private List<NftsDTO> nfts;

        @NoArgsConstructor
        @Data
        public static class NftsDTO {
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
}
