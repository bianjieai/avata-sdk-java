package ai.bianjie.avatasdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QueryAccountsHistoryReq {
    @JSONField(name = "page_key")
    private String pageKey;// 分页数据的Key， Avata会根据该值进行上下页的查询， 该值请从返回的数据体中获取，首页查询可以不传该参数
    @JSONField(name = "limit")
    private String limit;// 每页记录数，默认为 10，上限为 50
    @JSONField(name = "account")
    private String account;// 链账户地址
    @JSONField(name = "module")
    private String module;// 功能模块；Enum: "nft" "mt"
    @JSONField(name = "operation")
    private String operation;// 操作类型，仅 module 不为空时有效，默认为 "all"。 module = nft 时，可选：issue_class / transfer_class / mint / edit / transfer / burn； module = mt 时，可选： issue_class / transfer_class / issue / mint / edit / transfer / burn。
    @JSONField(name = "tx_hash")
    private String txHash;// Tx Hash
    @JSONField(name = "start_date")
    private String startDate;// 日期范围 - 开始，yyyy-MM-dd（UTC 时间）
    @JSONField(name = "end_date")
    private String endDate;// 日期范围 - 结束，yyyy-MM-dd（UTC 时间）
    @JSONField(name = "sort_by")
    private String sortBy;// 排序规则：DATE_ASC / DATE_DESC
    @JSONField(name = "count_total")
    private int countTotal;// 是否查询数据的总数量0：不查询总数（默认） 1：查询总数
}
