package model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.List;

@NoArgsConstructor
@Data
public class QueryAccountsHistoryRes extends BaseResponse {

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
            @JSONField(name = "module")
            private String module;
            @JSONField(name = "operation")
            private String operation;
            @JSONField(name = "signer")
            private String signer;
            @JSONField(name = "timestamp")
            private String timestamp;
            @JSONField(name = "gas_fee")
            private Integer gasFee;
            @JSONField(name = "business_fee")
            private Integer businessFee;
            @JSONField(name = "nft_msg")
            private DataDTO.OperationRecordsDTO.NftMsgDTO nftMsg;
            @JSONField(name = "mt_msg")
            private DataDTO.OperationRecordsDTO.MtMsgDTO mtMsg;

            @NoArgsConstructor
            @Data
            public static class NftMsgDTO {
                @JSONField(name = "id")
                private String id;
                @JSONField(name = "name")
                private String name;
                @JSONField(name = "class_id")
                private String classId;
                @JSONField(name = "class_name")
                private String className;
                @JSONField(name = "class_symbol")
                private String classSymbol;
                @JSONField(name = "symbol")
                private String symbol;
                @JSONField(name = "uri")
                private String uri;
                @JSONField(name = "recipient")
                private String recipient;
            }

            @NoArgsConstructor
            @Data
            public static class MtMsgDTO {
                @JSONField(name = "id")
                private String id;
                @JSONField(name = "class_id")
                private String classId;
                @JSONField(name = "class_name")
                private String className;
                @JSONField(name = "name")
                private String name;
                @JSONField(name = "recipient")
                private String recipient;
                @JSONField(name = "amount")
                private Integer amount;
            }
        }
    }
}
