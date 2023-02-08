package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.List;

/**
 * 查询 MT 类别返回值
 */
@NoArgsConstructor
@Data
public class QueryMtClassesRes extends BaseResponse {

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
