package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.List;

@NoArgsConstructor
@Data
public class QueryMtBalancesRes extends BaseResponse {

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
            @JSONField(name = "amount")
            private Integer amount;
        }
    }
}
