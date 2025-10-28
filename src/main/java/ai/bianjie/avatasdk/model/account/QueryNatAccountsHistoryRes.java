package ai.bianjie.avatasdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询原生链账户操作记录正确返回值
 */
@NoArgsConstructor
@Data
public class QueryNatAccountsHistoryRes {

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
            private String txHash;// 操作 Tx Hash

            @JSONField(name = "module")
            private Integer module;// 功能模块；Enum: "nft"

            @JSONField(name = "operation")
            private Integer operation;
            // 操作类型： module = 1 时： 1：issue_class； 2：transfer_class 3：mint； 4：edit； 5：transfer； 6：burn；
            // module = 2 时，可选：1：issue_class；2：transfer_class；3：issue；4：mint；5：edit；6：transfer；7：burn

            @JSONField(name = "signer")
            private String signer;// Tx 签名者地址

            @JSONField(name = "timestamp")
            private String timestamp;// 操作时间戳（UTC 时间）

            @JSONField(name = "nft_msg")
            private String nftMsg;// 具体参考接口文档

            @JSONField(name = "mt_msg")
            private String mtMsg;// 具体参考接口文档
        }
    }
}
