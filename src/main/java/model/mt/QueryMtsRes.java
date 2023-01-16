package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.List;

@NoArgsConstructor
@Data
public class QueryMtsRes extends BaseResponse {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "offset")
        private Integer offset;
        @JSONField(name = "limit")
        private Integer limit;
        @JSONField(name = "total_count")
        private Integer totalCount;
        @JSONField(name = "mts")
        private List<MtsDTO> mts;

        @NoArgsConstructor
        @Data
        public static class MtsDTO {
            @JSONField(name = "id")
            private String id;
            @JSONField(name = "class_id")
            private String classId;
            @JSONField(name = "class_name")
            private String className;
            @JSONField(name = "issuer")
            private String issuer;
            @JSONField(name = "owner_count")
            private Integer ownerCount;
            @JSONField(name = "timestamp")
            private String timestamp;
        }
    }
}
