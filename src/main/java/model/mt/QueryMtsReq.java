package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QueryMtsReq {
    @JSONField(name = "offset")
    private String offset;
    @JSONField(name = "limit")
    private String limit;
    @JSONField(name = "id")
    private String id;
    @JSONField(name = "class_id")
    private String classId;
    @JSONField(name = "issuer")
    private String issuer;
    @JSONField(name = "tx_hash")
    private String txHash;
    @JSONField(name = "start_date")
    private String startDate;
    @JSONField(name = "end_date")
    private String endDate;
    @JSONField(name = "sort_by")
    private String sortBy;
}
