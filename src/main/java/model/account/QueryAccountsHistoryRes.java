package model.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.List;

@NoArgsConstructor
@Data
public class QueryAccountsHistoryRes extends BaseResponse {

    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        private Integer offset;
        private Integer limit;
        private Integer totalCount;
        private List<OperationRecordsDTO> operationRecords;

        @NoArgsConstructor
        @Data
        public static class OperationRecordsDTO {
            private String txHash;
            private String module;
            private String operation;
            private String signer;
            private String timestamp;
            private Integer gasFee;
            private Integer businessFee;
            private DataDTO.OperationRecordsDTO.NftMsgDTO nftMsg;
            private DataDTO.OperationRecordsDTO.MtMsgDTO mtMsg;

            @NoArgsConstructor
            @Data
            public static class NftMsgDTO {
                private String id;
                private String name;
                private String classId;
                private String className;
                private String classSymbol;
                private String symbol;
                private String uri;
                private String recipient;
            }

            @NoArgsConstructor
            @Data
            public static class MtMsgDTO {
                private String id;
                private String classId;
                private String className;
                private String name;
                private String recipient;
                private Integer amount;
            }
        }
    }
}
