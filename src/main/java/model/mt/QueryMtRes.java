package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询 MT 详情返回值
 */
@NoArgsConstructor
@Data
public class QueryMtRes {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "id")
        private String id;// MT ID
        @JSONField(name = "class_id")
        private String classId;// MT 类别 ID
        @JSONField(name = "class_name")
        private String className;// MT 类别名称
        @JSONField(name = "data")
        private String data;// 自定义链上元数据
        @JSONField(name = "owner_count")
        private Integer ownerCount;// MT 拥有者数量(AVATA 平台内)
        @JSONField(name = "issue_data")
        private DataDTO.IssueDataDTO issueData;
        @JSONField(name = "mt_count")
        private Integer mtCount;// MT 流通总量(全链)
        @JSONField(name = "mint_times")
        private Integer mintTimes;// MT 发行次数(AVATA 平台内累计发行次数(包括首次发行和增发))

        @NoArgsConstructor
        @Data
        public static class IssueDataDTO {
            @JSONField(name = "issuer")
            private String issuer;// 首次发行该 MT 的链账户地址
            @JSONField(name = "timestamp")
            private String timestamp;// 首次发行该 MT 的时间戳
            @JSONField(name = "count")
            private Integer count;// 首次发行该 MT 的数量
            @JSONField(name = "tx_hash")
            private String txHash;// 首次发行该 MT 的交易哈希
        }
    }
}
