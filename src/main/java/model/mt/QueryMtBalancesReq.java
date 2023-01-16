package model.mt;

import com.alibaba.fastjson.annotation.JSONField;

public class QueryMtBalancesReq {
    @JSONField(name = "offset")
    private Integer offset;
    @JSONField(name = "limit")
    private Integer limit;
    @JSONField(name = "id")
    private Integer id;
}
