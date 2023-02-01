package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QueryMtHistoryReq {
    @JSONField(name = "offset")
    private Integer offset;
    @JSONField(name = "limit")
    private Integer limit;
    @JSONField(name = "signer")
    private Integer signer;
    @JSONField(name = "tx_hash")
    private Integer txHash;
    @JSONField(name = "operation")
    private Integer operation;
    @JSONField(name = "start_date")
    private Integer startDate;
    @JSONField(name = "end_date")
    private Integer endDate;
    @JSONField(name = "sort_by")
    private Integer sortBy;
}
