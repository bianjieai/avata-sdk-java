package ai.bianjie.avatasdk.model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询 NFT ：Response
 */
@NoArgsConstructor
@Data
public class QueryNftsRes {
    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "prev_page_key")
        private String prevPageKey;// 上一页数据的Key， Avata会根据该值进行上一页数据的查询
        @JSONField(name = "next_page_key")
        private String nextPageKey;//下一页数据的Key， Avata会根据该值进行下一页数据的查询

        @JSONField(name = "limit")
        private Integer limit;// 每页记录数

        @JSONField(name = "total_count")
        private Integer totalCount;// 总记录数

        @JSONField(name = "nfts")
        private List<NftsDTO> nfts;

        @NoArgsConstructor
        @Data
        public static class NftsDTO {
            @JSONField(name = "id")
            private String id;// NFT ID


            @JSONField(name = "class_id")
            private String classId;// NFT 类别 ID

            @JSONField(name = "class_name")
            private String className;// NFT 类别名称

            @JSONField(name = "class_symbol")
            private String classSymbol;// NFT 类别标识

            @JSONField(name = "uri")
            private String uri;// 链外数据链接

            @JSONField(name = "owner")
            private String owner;// NFT 持有者地址

            @JSONField(name = "status")
            private String status;// NFT 状态：active / burned;

            @JSONField(name = "tx_hash")
            private String txHash;// NFT 发行 Tx Hash

            @JSONField(name = "timestamp")
            private String timestamp;// NFT 发行时间戳（UTC 时间）
        }
    }
}
