package ai.bianjie.avatasdk.model.evm.nft;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询 NFT 操作记录正确返回值
 */
@NoArgsConstructor
@Data
public class QueryNftHistoryRes {

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

        @JSONField(name = "operation_records")
        private List<OperationRecordsDTO> operationRecords;// 操作记录列表

        @NoArgsConstructor
        @Data
        public static class OperationRecordsDTO {

            @JSONField(name = "tx_hash")
            private String txHash;// NFT 操作的 Tx Hash

            @JSONField(name = "operation")
            private Integer operation;// NFT 操作类型： 1：mint； 2：edit； 3：transfer； 4：burn；

            @JSONField(name = "signer")
            private String signer;// Tx 签名者地址

            @JSONField(name = "recipient")
            private String recipient;// NFT 接收者地址

            @JSONField(name = "timestamp")
            private String timestamp;// NFT 操作时间戳（UTC 时间）
        }
    }
}
