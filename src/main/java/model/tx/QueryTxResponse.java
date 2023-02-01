package model.tx;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.Map;

@NoArgsConstructor
@Data
public class QueryTxResponse extends BaseResponse {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "type")
        private String type;
        @JSONField(name = "module")
        private String module;
        @JSONField(name = "tx_hash")
        private String txHash;
        @JSONField(name = "status")
        private Integer status;
        @JSONField(name = "message")
        private String message;
        @JSONField(name = "block_height")
        private Integer blockHeight;
        @JSONField(name = "timestamp")
        private String timestamp;
        @JSONField(name = "tag")
        private Map<String, Object> tag;
        @JSONField(name = "nft")
        private Nft nft;
        @JSONField(name = "mt")
        private Mt mt;
        @JSONField(name = "record")
        private Record record;

        @NoArgsConstructor
        @Data
        public static class Nft {
            @JSONField(name = "class_id")
            private String classId;
            @JSONField(name = "nft_id")
            private String nftId;
        }

        @NoArgsConstructor
        @Data
        public static class Mt {
            @JSONField(name = "class_id")
            private String classId;
            @JSONField(name = "mt_id")
            private String mtId;
        }

        @NoArgsConstructor
        @Data
        public static class Record {
            @JSONField(name = "record_id")
            private String recordId;
            @JSONField(name = "certificate_url")
            private String certificateUrl;
        }
    }
}

