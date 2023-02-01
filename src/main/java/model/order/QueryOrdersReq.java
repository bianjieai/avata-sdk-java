package model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QueryOrdersReq {
    @JSONField(name = "offset")
    private String offset;
    @JSONField(name = "limit")
    private String limit;
    @JSONField(name = "status")
    private String status;
    @JSONField(name = "start_date")
    private String startDate;
    @JSONField(name = "end_date")
    private String endDate;
    @JSONField(name = "sort_by")
    private String sortBy;
}
