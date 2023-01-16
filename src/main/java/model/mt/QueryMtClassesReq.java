package model.mt;

import com.alibaba.fastjson.annotation.JSONField;

public class QueryMtClassesReq {
    @JSONField(name = "offset")
    private Integer offset;
    @JSONField(name = "limit")
    private Integer limit;
    @JSONField(name = "id")
    private Integer id;
    @JSONField(name = "name")
    private Integer name;
    @JSONField(name = "owner")
    private Integer owner;
    @JSONField(name = "tx_hash")
    private Integer txHash;
    @JSONField(name = "start_date")
    private Integer startDate;
    @JSONField(name = "end_date")
    private Integer endDate;
    @JSONField(name = "sort_by")
    private Integer sortBy;
}
