package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

@NoArgsConstructor
@Data
public class QueryMtRes extends BaseResponse {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "id")
        private String id;
        @JSONField(name = "class_id")
        private String classId;
        @JSONField(name = "class_name")
        private String className;
        @JSONField(name = "data")
        private String data;
        @JSONField(name = "owner_count")
        private Integer ownerCount;
        @JSONField(name = "issue_data")
        private DataDTO.IssueDataDTO issueData;
        @JSONField(name = "mt_count")
        private Integer mtCount;
        @JSONField(name = "mint_times")
        private Integer mintTimes;

        @NoArgsConstructor
        @Data
        public static class IssueDataDTO {
            @JSONField(name = "issuer")
            private String issuer;
            @JSONField(name = "timestamp")
            private String timestamp;
            @JSONField(name = "count")
            private Integer count;
            @JSONField(name = "tx_hash")
            private String txHash;
        }
    }
}
