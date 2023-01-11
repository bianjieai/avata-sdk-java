package model.nft;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class BatchCreateNftReq {

    private String name;
    private String uri;
    private String uriHash;
    private String data;
    private List<RecipientsDTO> recipients;
    private String tag;
    private String operationId;

    @NoArgsConstructor
    @Data
    public static class RecipientsDTO {
        private Integer amount;
        private String recipient;
    }
}
