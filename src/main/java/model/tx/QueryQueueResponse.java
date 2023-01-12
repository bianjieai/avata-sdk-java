package model.tx;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

@NoArgsConstructor
@Data
public class QueryQueueResponse extends BaseResponse {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "queue_total")
        private Integer queueTotal;
        @JSONField(name = "queue_request_time")
        private String queueRequestTime;
        @JSONField(name = "queue_cost_time")
        private Integer queueCostTime;
        @JSONField(name = "tx_queue_position")
        private Integer txQueuePosition;
        @JSONField(name = "tx_request_time")
        private String txRequestTime;
        @JSONField(name = "tx_cost_time")
        private Integer txCostTime;
        @JSONField(name = "tx_message")
        private String txMessage;
    }
}
