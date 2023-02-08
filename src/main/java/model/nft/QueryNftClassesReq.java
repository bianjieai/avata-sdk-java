package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询 NFT 类别：request
 */
@NoArgsConstructor
@Data
public class QueryNftClassesReq {
    @JSONField(name = "offset")
    private String offset;// 游标，默认为 0
    @JSONField(name = "limit")
    private String limit;// 每页记录数，默认为 10，上限为 50
    @JSONField(name = "id")
    private String id;// NFT 类别 ID
    @JSONField(name = "name")
    private String name;// NFT 类别名称，支持模糊查询
    @JSONField(name = "owner")
    private String owner;// NFT 类别权属者地址
    @JSONField(name = "txHash")
    private String tx_hash;// 创建 NFT 类别的 Tx Hash
    @JSONField(name = "start_date")
    private String startDate;// NFT 类别创建日期范围 - 开始，yyyy-MM-dd（UTC 时间）
    @JSONField(name = "end_date")
    private String endDate;// NFT 类别创建日期范围 - 结束，yyyy-MM-dd（UTC 时间）
    @JSONField(name = "sort_by")
    private String sortBy;// 排序规则：DATE_ASC / DATE_DESC
}
