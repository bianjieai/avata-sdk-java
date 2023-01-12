package model.nft;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class BatchCreateNftReq {

    private String name;
    private String uri;
    private String uri_hash;
    private String data;
    private List<RecipientsDTO> recipients;
    private String tag;
    private String operation_id;

    @NoArgsConstructor
    @Data
    public static class RecipientsDTO {
        private Integer amount;
        private String recipient;
    }
}
