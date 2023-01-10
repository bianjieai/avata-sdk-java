package model.tx;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

@NoArgsConstructor
@Data
public class QueryTxResponse extends BaseResponse {

    private DataDTO data;

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getModule() {
            return module;
        }

        public void setModule(String module) {
            this.module = module;
        }

        public String getTxHash() {
            return txHash;
        }

        public void setTxHash(String txHash) {
            this.txHash = txHash;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Integer getBlockHeight() {
            return blockHeight;
        }

        public void setBlockHeight(Integer blockHeight) {
            this.blockHeight = blockHeight;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getNft() {
            return nft;
        }

        public void setNft(String nft) {
            this.nft = nft;
        }

        public String getMt() {
            return mt;
        }

        public void setMt(String mt) {
            this.mt = mt;
        }

        public RecordDTO getRecord() {
            return record;
        }

        public void setRecord(RecordDTO record) {
            this.record = record;
        }

        @NoArgsConstructor
        @Data
        public static class RecordDTO {
            private DataDTO.RecordDTO.CreateRecordDTO createRecord;

            public CreateRecordDTO getCreateRecord() {
                return createRecord;
            }

            public void setCreateRecord(CreateRecordDTO createRecord) {
                this.createRecord = createRecord;
            }

            @NoArgsConstructor
            @Data
            public static class CreateRecordDTO {
                private String recordId;
                private String certificateUrl;

                public String getRecordId() {
                    return recordId;
                }

                public void setRecordId(String recordId) {
                    this.recordId = recordId;
                }

                public String getCertificateUrl() {
                    return certificateUrl;
                }

                public void setCertificateUrl(String certificateUrl) {
                    this.certificateUrl = certificateUrl;
                }
            }
        }
    }
}
