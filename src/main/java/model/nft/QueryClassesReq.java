package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QueryClassesReq {
    @JSONField(name = "offset")
    private String offset;
    @JSONField(name = "limit")
    private String limit;
    @JSONField(name = "id")
    private String id;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "owner")
    private String owner;
    @JSONField(name = "txHash")
    private String tx_hash;
    @JSONField(name = "start_date")
    private String startDate;
    @JSONField(name = "end_date")
    private String endDate;
    @JSONField(name = "sort_by")
    private String sortBy;

}
