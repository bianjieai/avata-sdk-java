package model.nft;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreateNftRequest {

    private String name;
    private String uri;
    private String uriHash;
    private String data;
    private String recipient;
    private String tag;
    private String operationId;
}
