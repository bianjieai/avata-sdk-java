package ai.bianjie.avatasdk.model.nat.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询 MT 类别正确返回值
 */
@NoArgsConstructor
@Data
public class QueryMtClassesRes {

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

        @JSONField(name = "classes")
        private List<ClassesDTO> classes;

        @NoArgsConstructor
        @Data
        public static class ClassesDTO {

            @JSONField(name = "id")
            private String id;// MT 类别 ID

            @JSONField(name = "name")
            private String name;// MT 类别名称

            @JSONField(name = "mt_count")
            private Integer mtCount;// MT 类别包含的 MT 总量(AVATA 平台内)

            @JSONField(name = "owner")
            private String owner;// MT 类别权属者地址

            @JSONField(name = "tx_hash")
            private String txHash;// 创建 MT 类别的 Tx Hash

            @JSONField(name = "timestamp")
            private String timestamp;// 创建 MT 类别的时间戳（UTC 时间）
        }
    }
}
