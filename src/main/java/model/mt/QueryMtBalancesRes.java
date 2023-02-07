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
        private Integer offset;// 游标
        @JSONField(name = "limit")
        private Integer limit;// 每页记录数
        @JSONField(name = "total_count")
        private Integer totalCount;// 总记录数
        @JSONField(name = "mts")
        private List<MtsDTO> mts;

        @NoArgsConstructor
        @Data
        public static class MtsDTO {
            @JSONField(name = "id")
            private String id;// MT ID
            @JSONField(name = "amount")
            private Integer amount;// MT 数量
        }
    }
}
