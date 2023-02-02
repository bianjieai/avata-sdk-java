package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
public class BatchEditNftReq {
    @JSONField(name = "nfts")
    private List<NftsDTO> nfts;

    @JSONField(name = "operation_id")
    private String operationId;

    @NoArgsConstructor
    @Data
    public static class NftsDTO {
        @JSONField(name = "class_id")
        private String classId;
        @JSONField(name = "nft_id")
        private String nftId;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "uri")
        private String uri;
        @JSONField(name = "data")
        private String data;
    }
}
