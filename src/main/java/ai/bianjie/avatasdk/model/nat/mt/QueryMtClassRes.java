package ai.bianjie.avatasdk.model.nat.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询 MT 类别详情正确返回值
 */
@NoArgsConstructor
@Data
public class QueryMtClassRes {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {

        @JSONField(name = "id")
        private String id;// MT 类别 ID

        @JSONField(name = "name")
        private String name;// MT 类别名称

        @JSONField(name = "data")
        private String data;// 自定义链上元数据

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
