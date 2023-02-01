package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
public class BatchTransferNftReq {
    @JSONField(name = "data")
    private List<DataDTO> data;
    @JSONField(name = "tag")
    private Map<String, Object> tag;
    @JSONField(name = "operation_id")
    private String operationId;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "nfts")
        private List<NftsDTO> nfts;
        @JSONField(name = "recipient")
        private String recipient;

        @NoArgsConstructor
        @Data
        public static class NftsDTO {
            @JSONField(name = "class_id")
            private String classId;
            @JSONField(name = "nft_id")
            private String nftId;
        }
    }
}
