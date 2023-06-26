package ai.bianjie.avatasdk.model.nat.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询 MT 正确返回值
 */
@NoArgsConstructor
@Data
public class QueryMtsRes {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {

        @JSONField(name = "prev_page_key")
        private String prevPageKey;// 上一页数据的Key， Avata会根据该值进行上一页数据的查询

        @JSONField(name = "next_page_key")
        private String nextPageKey;// 下一页数据的Key， Avata会根据该值进行上一页数据的查询

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
