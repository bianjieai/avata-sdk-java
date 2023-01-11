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
        private Nft nft;
        private Mt mt;
        private Record record;

        @NoArgsConstructor
        @Data
        public static class Nft {
            private String classId;
            private String nftId;
        }

        @NoArgsConstructor
        @Data
        public static class Mt {
            private String classId;
            private String mtId;
        }

        @NoArgsConstructor
        @Data
        public static class Record {
            private CreateRecord createRecord;

            @NoArgsConstructor
            @Data
            public static class CreateRecord {
                private String recordId;
                private String certificateUrl;
            }
        }
    }
}
