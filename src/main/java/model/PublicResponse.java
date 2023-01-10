package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PublicResponse {

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
        private String operationId;

        public String getOperationId() {
            return operationId;
        }

        public void setOperationId(String operationId) {
            this.operationId = operationId;
        }
    }
}
