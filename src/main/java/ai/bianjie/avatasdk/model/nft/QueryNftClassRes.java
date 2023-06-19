package ai.bianjie.avatasdk.model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询 NFT 类别详情正确返回值
 */
@NoArgsConstructor
@Data
public class QueryNftClassRes {
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {

        @JSONField(name = "id")
        private String id;// NFT 合约地址

        @JSONField(name = "name")
        private String name;// NFT 类别名称

        @JSONField(name = "uri")
        private String uri;// 链外资源标识符

        @JSONField(name = "symbol")
        private String symbol;// NFT 类别标识

        @JSONField(name = "nft_count")
        private Integer nftCount;// NFT 类别包含的 NFT 总量

        @JSONField(name = "owner")
        private String owner;// NFT 类别权属者地址

        @JSONField(name = "editable_by_owner")
        private Integer editableByOwner;// NFT 类别权限的控制功能， 此类别下某一 NFT 的持有者可以编辑该 NFT, 1:可编辑, 0:不可编辑

        @JSONField(name = "editable_by_class_owner")
        private Integer editableByClassOwner;// NFT 类别权限的控制功能， 此 NFT 类别的权属者可以编辑这个类别下所有的 NFT, 1:可编辑, 0:不可编辑

        @JSONField(name = "tx_hash")
        private String txHash;// 部署合约的 Tx Hash

        @JSONField(name = "timestamp")
        private String timestamp;// 部署合约的时间戳（UTC 时间）
    }
}
