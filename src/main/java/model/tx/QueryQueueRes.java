package model.tx;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

/**
 * 上链交易排队状态查询返回值
 */
@NoArgsConstructor
@Data
public class QueryQueueRes extends BaseResponse {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "queue_total")
        private Integer queueTotal;// 当前队列中待处理交易总数
        @JSONField(name = "queue_request_time")
        private String queueRequestTime;// 当前队列即将被处理交易的请求时间（UTC 时间）
        @JSONField(name = "queue_cost_time")
        private Integer queueCostTime;// 当前队列中所有交易处理完预估时间（秒）
        @JSONField(name = "tx_queue_position")
        private Integer txQueuePosition;// Operation ID 对应交易所处队列中的位置；若交易存在队列中，0 则表示正在重试
        @JSONField(name = "tx_request_time")
        private String txRequestTime;// Operation ID 对应交易的请求时间（UTC 时间）
        @JSONField(name = "tx_cost_time")
        private Integer txCostTime;// Operation ID 对应交易预估处理所需时间（秒）
        @JSONField(name = "tx_message")
        private String txMessage;// Operation ID 对应交易排队描述信息
    }
}
