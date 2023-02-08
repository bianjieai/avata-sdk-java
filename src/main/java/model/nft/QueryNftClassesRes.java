package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.List;


/**
 * 查询 NFT 类别：Response
 */
@NoArgsConstructor
@Data
public class QueryNftClassesRes extends BaseResponse {
    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "offset")
        private Integer offset;// 游标
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
            private String id;// NFT 类别 ID
            @JSONField(name = "name")
            private String name;// NFT 类别名称
            @JSONField(name = "symbol")
            private String symbol;// NFT 类别标识
            @JSONField(name = "nft_count")
            private Integer nftCount;// NFT 类别包含的 NFT 总量
            @JSONField(name = "uri")
            private String uri;// 链外数据链接
            @JSONField(name = "owner")
            private String owner;// NFT 类别权属者地址
            @JSONField(name = "tx_hash")
            private String txHash;// 创建 NFT 类别的 Tx Hash
            @JSONField(name = "timestamp")
            private String timestamp;// 创建 NFT 类别的时间戳（UTC 时间）
        }
    }
}
