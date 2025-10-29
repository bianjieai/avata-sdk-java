package ai.bianjie.avatasdk.model.nat.nft;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询 NFT 操作记录请求体
 */
@NoArgsConstructor
@Data
public class QueryNftHistoryReq {

    @JSONField(name = "page_key")
    private String pageKey;// 分页数据的Key， Avata会根据该值进行上下页的查询， 该值请从返回的数据体中获取，首页查询可以不传该参数

    @JSONField(name = "limit")
    private String limit;// 每页记录数，默认为 10，上限为 50

    @JSONField(name = "signer")
    private String signer;// Tx 签名者地址

    @JSONField(name = "tx_hash")
    private String txHash;// NFT 操作 Tx Hash

    @JSONField(name = "operation")
    private String operation;// 操作类型：1：mint； 2：edit； 3：transfer； 4：burn；

    @JSONField(name = "start_date")
    private String startDate;// NFT 操作日期范围 - 开始，yyyy-MM-dd（UTC 时间）

    @JSONField(name = "end_date")
    private String endDate;// NFT 操作日期范围 - 结束，yyyy-MM-dd（UTC 时间）

    @JSONField(name = "sort_by")
    private String sortBy;// 排序规则：DATE_ASC / DATE_DESC

    @JSONField(name = "count_total")
    private String countTotal;// 是否查询数据的总数量 0：不查询总数（默认）1：查询总数
}
