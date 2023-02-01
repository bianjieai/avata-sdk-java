package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QueryNftsReq {

    @JSONField(name = "offset")
    private String offset;

    @JSONField(name = "limit")
    private String limit;

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "class_id")
    private String classId;

    @JSONField(name = "owner")
    private String owner;

    @JSONField(name = "tx_hash")
    private String txHash;

    @JSONField(name = "status")
    private String status;

    @JSONField(name = "start_date")
    private String startDate;

    @JSONField(name = "end_date")
    private String endDate;

    @JSONField(name = "sort_by")
    private String sortBy;

}
