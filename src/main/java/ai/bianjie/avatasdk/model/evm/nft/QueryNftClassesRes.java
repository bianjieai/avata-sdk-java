package ai.bianjie.avatasdk.model.evm.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询 NFT 类别正确返回值
 */
@NoArgsConstructor
@Data
public class QueryNftClassesRes {
    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {

        @JSONField(name = "prev_page_key")
        private String prevPageKey;// 上一页数据的Key， Avata会根据该值进行上一页数据的查询

        @JSONField(name = "next_page_key")
        private String nextPageKey;// 下一页数据的Key， Avata会根据该值进行上一页数据的查询

        @JSONField(name = "limit")
        private Integer limit;// 每页记录数

        @JSONField(name = "total_count")
        private Integer totalCount;// 总记录数

        @JSONField(name = "classes")
        private List<ClassesDTO> classes;


        @NoArgsConstructor
        @Data
        public static class ClassesDTO {
            @JSONField(name = "id")
            private String id;// NFT 合约地址

            @JSONField(name = "name")
            private String name;// NFT 类别名称

            @JSONField(name = "uri")
            private String uri;// 链外数据链接

            @JSONField(name = "symbol")
            private String symbol;// NFT 类别标识

            @JSONField(name = "owner")
            private String owner;// NFT 类别权属者地址

            @JSONField(name = "tx_hash")
            private String txHash;// 部署合约的 Tx Hash

            @JSONField(name = "timestamp")
            private String timestamp;// 部署合约的时间戳（UTC 时间）
        }
    }
}
