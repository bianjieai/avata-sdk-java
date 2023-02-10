package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询 MT 操作记录返回值
 */
@NoArgsConstructor
@Data
public class QueryMtHistoryRes {

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
        @JSONField(name = "operation_records")
        private List<OperationRecordsDTO> operationRecords;

        @NoArgsConstructor
        @Data
        public static class OperationRecordsDTO {
            @JSONField(name = "tx_hash")
            private String txHash;// MT 操作的 Tx Hash
            @JSONField(name = "operation")
            private String operation;// MT 操作类型；Enum: "issue" "mint" "edit" "transfer" "burn"
            @JSONField(name = "signer")
            private String signer;// Tx 签名者地址
            @JSONField(name = "recipient")
            private String recipient;// MT 接收者地址
            @JSONField(name = "amount")
            private Integer amount;// MT 操作数量
            @JSONField(name = "timestamp")
            private String timestamp;// MT 操作时间戳（UTC 时间）
        }
    }
}
