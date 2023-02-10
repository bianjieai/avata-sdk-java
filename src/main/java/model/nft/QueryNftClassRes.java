package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询 NFT 类别详情：Response
 */
@NoArgsConstructor
@Data
public class QueryNftClassRes {
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "id")
        private String id;// NFT 类别 ID
        @JSONField(name = "name")
        private String name;// NFT 类别名称
        @JSONField(name = "symbol")
        private String symbol;// NFT 类别标识
        @JSONField(name = "description")
        private String description;// NFT 类别描述
        @JSONField(name = "nft_count")
        private Integer nftCount;// NFT 类别包含的 NFT 总量
        @JSONField(name = "uri")
        private String uri;// 链外数据链接
        @JSONField(name = "uri_hash")
        private String uriHash;// 链外数据 Hash
        @JSONField(name = "data")
        private String data;// 自定义链上元数据
        @JSONField(name = "owner")
        private String owner;// NFT 类别权属者地址
        @JSONField(name = "tx_hash")
        private String txHash;// 创建 NFT 类别的 Tx Hash
        @JSONField(name = "timestamp")
        private String timestamp;// 创建 NFT 类别的时间戳（UTC 时间）
    }
}
