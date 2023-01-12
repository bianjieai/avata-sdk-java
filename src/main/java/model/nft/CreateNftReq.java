package model.nft;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Data
public class CreateNftReq {

    private String name;
    private String uri;
    private String uri_hash;
    private String data;
    private String recipient;
    private Map<String, Object> tag;
    private String operation_id;
}
