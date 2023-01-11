package model.tx;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

@NoArgsConstructor
@Data
public class QueryQueueResponse extends BaseResponse {

    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        private Integer queueTotal;
        private String queueRequestTime;
        private Integer queueCostTime;
        private Integer txQueuePosition;
        private String txRequestTime;
        private Integer txCostTime;
        private String txMessage;
    }
}
