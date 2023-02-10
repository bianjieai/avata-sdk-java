package ai.bianjie.avatasdk.model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询 NFT ：request
 */
@NoArgsConstructor
@Data
public class QueryNftsReq {

    @JSONField(name = "offset")
    private String offset;// 游标，默认为 0

    @JSONField(name = "limit")
    private String limit;// 每页记录数，默认为 10，上限为 50

    @JSONField(name = "id")
    private String id;// NFT ID

    @JSONField(name = "name")
    private String name;// NFT 名称，支持模糊查询

    @JSONField(name = "class_id")
    private String classId;// NFT 类别 ID

    @JSONField(name = "owner")
    private String owner;// NFT 持有者地址

    @JSONField(name = "tx_hash")
    private String txHash;// 创建 NFT 的 Tx Hash

    @JSONField(name = "status")
    private String status;// NFT 状态：active / burned，默认为 active

    @JSONField(name = "start_date")
    private String startDate;// NFT 创建日期范围 - 开始，yyyy-MM-dd（UTC 时间）

    @JSONField(name = "end_date")
    private String endDate;// NFT 创建日期范围 - 结束，yyyy-MM-dd（UTC 时间）

    @JSONField(name = "sort_by")
    private String sortBy;// 排序规则：DATE_ASC / DATE_DESC

}
