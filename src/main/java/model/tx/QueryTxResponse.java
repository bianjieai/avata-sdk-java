package model.tx;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

@NoArgsConstructor
@Data
public class QueryTxResponse extends BaseResponse {

    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        private String type;
        private String module;
        private String txHash;
        private Integer status;
        private String message;
        private Integer blockHeight;
        private String timestamp;
        private String tag;
        private String nft;
        private String mt;
        private DataDTO.RecordDTO record;

        @NoArgsConstructor
        @Data
        public static class RecordDTO {
            private DataDTO.RecordDTO.CreateRecordDTO createRecord;

            @NoArgsConstructor
            @Data
            public static class CreateRecordDTO {
                private String recordId;
                private String certificateUrl;
            }
        }
    }
}
