package model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QueryAccountsReq {
    @JSONField(name = "offset")
    private String offset;
    @JSONField(name = "limit")
    private String limit;
    @JSONField(name = "account")
    private String account;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "operation_id")
    private String operationId;
    @JSONField(name = "start_date")
    private String startDate;
    @JSONField(name = "end_date")
    private String endDate;
    @JSONField(name = "sort_by")
    private String sortBy;
}
