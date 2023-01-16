package model.mt;

import com.alibaba.fastjson.annotation.JSONField;

public class QueryMtReq {
    @JSONField(name = "offset")
    private Integer offset;
    @JSONField(name = "limit")
    private Integer limit;
    @JSONField(name = "id")
    private Integer id;
    @JSONField(name = "class_id")
    private Integer classId;
    @JSONField(name = "issuer")
    private Integer issuer;
    @JSONField(name = "tx_hash")
    private Integer txHash;
    @JSONField(name = "start_date")
    private Integer startDate;
    @JSONField(name = "end_date")
    private Integer endDate;
    @JSONField(name = "sort_by")
    private Integer sortBy;
}
