package model.nft;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
public class BatchDeleteNftReq {

    private List<NftsDTO> nfts;
    private Map<String, Object> tag;
    private String operation_id;

    @NoArgsConstructor
    @Data
    public static class NftsDTO {
        private String classId;
        private String nftId;
    }
}
