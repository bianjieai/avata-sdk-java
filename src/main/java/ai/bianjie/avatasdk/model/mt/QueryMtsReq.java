package ai.bianjie.avatasdk.model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询 MT 请求参数
 */
@NoArgsConstructor
@Data
public class QueryMtsReq {
    @JSONField(name = "offset")
    private String offset;// 游标，默认为 0
    @JSONField(name = "limit")
    private String limit;// 每页记录数，默认为 10，上限为 50
    @JSONField(name = "id")
    private String id;// MT ID
    @JSONField(name = "class_id")
    private String classId;// MT 类别 ID
    @JSONField(name = "issuer")
    private String issuer;// MT 发行者地址
    @JSONField(name = "tx_hash")
    private String txHash;// 创建 MT 的 TX Hash
    @JSONField(name = "start_date")
    private String startDate;// MT 创建日期范围 - 开始，yyyy-MM-dd（UTC 时间）
    @JSONField(name = "end_date")
    private String endDate;// MT 创建日期范围 - 结束，yyyy-MM-dd（UTC 时间）
    @JSONField(name = "sort_by")
    private String sortBy;// 排序规则：DATE_ASC / DATE_DESC
}
