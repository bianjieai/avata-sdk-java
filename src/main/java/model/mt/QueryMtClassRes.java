package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

@NoArgsConstructor
@Data
public class QueryMtClassRes extends BaseResponse {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "id")
        private String id;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "mt_count")
        private Integer mtCount;
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
