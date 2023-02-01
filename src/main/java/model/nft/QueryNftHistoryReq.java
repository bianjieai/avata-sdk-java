package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.List;

@NoArgsConstructor
@Data
public class QueryNftHistoryReq extends BaseResponse {

    @JSONField(name = "offset")
    private String offset;

    @JSONField(name = "limit")
    private String limit;

    @JSONField(name = "signer")
    private String signer;

    @JSONField(name = "tx_hash")
    private String txHash;

    @JSONField(name = "operation")
    private String operation;

    @JSONField(name = "start_date")
    private String startDate;

    @JSONField(name = "end_date")
    private String endDate;

    @JSONField(name = "sort_by")
    private String sortBy;
}
