package model.order;

import com.alibaba.fastjson.annotation.JSONField;

public class QueryOrderReq {
    @JSONField(name = "offset")
    private Integer offset;// 游标，默认为 0
    @JSONField(name = "limit")
    private Integer limit;// 每页记录数，默认为 10，上限为 50
    @JSONField(name = "status")
    private Integer status;
    @JSONField(name = "start_date")
    private Integer startDate;
    @JSONField(name = "end_date")
    private Integer endDate;
    @JSONField(name = "sort_by")
    private Integer sortBy;
}
