package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询 NFT 操作记录：request
 */
@NoArgsConstructor
@Data
public class QueryNftHistoryReq {

    @JSONField(name = "offset")
    private String offset;// 游标，默认为 0

    @JSONField(name = "limit")
    private String limit;// 每页记录数，默认为 10，上限为 50

    @JSONField(name = "signer")
    private String signer;// Tx 签名者地址

    @JSONField(name = "tx_hash")
    private String txHash;// NFT 操作 Tx Hash

    @JSONField(name = "operation")
    private String operation;// 操作类型：mint / edit / transfer / burn

    @JSONField(name = "start_date")
    private String startDate;// NFT 操作日期范围 - 开始，yyyy-MM-dd（UTC 时间）

    @JSONField(name = "end_date")
    private String endDate;// NFT 操作日期范围 - 结束，yyyy-MM-dd（UTC 时间）

    @JSONField(name = "sort_by")
    private String sortBy;// 排序规则：DATE_ASC / DATE_DESC
}
