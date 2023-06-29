package ai.bianjie.avatasdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EVM 查询链账户操作记录请求体
 */
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
    private String module;// 功能模块：1：nft；


    // 原生项目：
    // 操作类型，仅 module 不为空时有效，默认为："0"（all）。
    // module = 1 时，可选：1：issue_class；2：transfer_class；3：mint； 4：edit；5：transfer；6：burn；
    // module = 2 时，可选：1：issue_class；2：transfer_class；3：issue；4：mint；5：edit；6：transfer；7：burn

    // EVM 项目：
    // 操作类型，仅 module 不为空时有效，默认为："0"（all）。
    // module = 1 时，可选：1：issue_class；2：transfer_class；3：mint； 4：edit；5：transfer；6：burn；
    @JSONField(name = "operation")
    private String operation;


    @JSONField(name = "tx_hash")
    private String txHash;// Tx Hash

    @JSONField(name = "start_date")
    private String startDate;// 日期范围 - 开始，yyyy-MM-dd（UTC 时间）

    @JSONField(name = "end_date")
    private String endDate;// 日期范围 - 结束，yyyy-MM-dd（UTC 时间）

    @JSONField(name = "sort_by")
    private String sortBy;// 排序规则：DATE_ASC / DATE_DESC

    @JSONField(name = "count_total")
    private String countTotal;// 是否查询数据的总数量 0：不查询总数（默认）1：查询总数
}
