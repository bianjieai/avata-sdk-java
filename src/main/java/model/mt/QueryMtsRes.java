package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.List;

/**
 * 查询 MT 返回值
 */
@NoArgsConstructor
@Data
public class QueryMtsRes extends BaseResponse {

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
            @JSONField(name = "class_id")
            private String classId;// MT 类别 ID
            @JSONField(name = "class_name")
            private String className;// MT 类别名称
            @JSONField(name = "issuer")
            private String issuer;// 首次发行该 MT 的链账户地址
            @JSONField(name = "owner_count")
            private Integer ownerCount;// MT 拥有者数量(AVATA 平台内)
            @JSONField(name = "timestamp")
            private String timestamp;// MT 首次发行时间戳（UTC 时间）
        }
    }
}
