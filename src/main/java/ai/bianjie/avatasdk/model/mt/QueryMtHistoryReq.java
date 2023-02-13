package ai.bianjie.avatasdk.model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询 MT 操作记录请求参数
 */
@NoArgsConstructor
@Data
public class QueryMtHistoryReq {
    @JSONField(name = "offset")
    private Integer offset;// 游标，默认为 0
    @JSONField(name = "limit")
    private Integer limit;// 每页记录数，默认为 10，上限为 50
    @JSONField(name = "signer")
    private Integer signer;// Tx 签名者地址
    @JSONField(name = "tx_hash")
    private Integer txHash;// MT 操作 Tx Hash
    @JSONField(name = "operation")
    private Integer operation;// 操作类型： issue(首发MT) / mint(增发MT) / edit(编辑MT) / transfer(转让MT) / burn(销毁MT)
    @JSONField(name = "start_date")
    private Integer startDate;// MT 操作日期范围 - 开始，yyyy-MM-dd（UTC 时间）
    @JSONField(name = "end_date")
    private Integer endDate;// MT 操作日期范围 - 结束，yyyy-MM-dd（UTC 时间）
    @JSONField(name = "sort_by")
    private Integer sortBy;// 排序规则：DATE_ASC / DATE_DESC
}
