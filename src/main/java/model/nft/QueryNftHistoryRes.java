package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.List;

@NoArgsConstructor
@Data
public class QueryNftHistoryRes extends BaseResponse {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {

        @JSONField(name = "offset")
        private Integer offset;

        @JSONField(name = "limit")
        private Integer limit;

        @JSONField(name = "total_count")
        private Integer totalCount;

        @JSONField(name = "operation_records")
        private List<OperationRecordsDTO> operationRecords;

        @NoArgsConstructor
        @Data
        public static class OperationRecordsDTO {

            @JSONField(name = "tx_hash")
            private String txHash;

            @JSONField(name = "operation")
            private String operation;

            @JSONField(name = "signer")
            private String signer;

            @JSONField(name = "recipient")
            private String recipient;

            @JSONField(name = "timestamp")
            private String timestamp;
        }
    }
}
