package ai.bianjie.avatasdk.model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询 NFT 详情正确返回值
 */
@NoArgsConstructor
@Data
public class QueryNftRes {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {

        @JSONField(name = "id")
        private Integer id;// NFT ID

        @JSONField(name = "class_id")
        private String classId;// NFT 类别 ID

        @JSONField(name = "class_name")
        private String className;// NFT 类别名称

        @JSONField(name = "class_symbol")
        private String classSymbol;// NFT 类别标识

        @JSONField(name = "uri")
        private String uri;// 链外数据链接

        @JSONField(name = "uri_hash")
        private String uriHash;// 链外数据 Hash

        @JSONField(name = "owner")
        private String owner;// NFT 持有者地址

        @JSONField(name = "status")
        private Integer status;// NFT 状态 1：active 2：burned

        @JSONField(name = "tx_hash")
        private String txHash;// NFT 发行 Tx Hash

        @JSONField(name = "timestamp")
        private String timestamp;// NFT 发行时间戳（UTC 时间）
    }
}
