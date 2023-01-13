package model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.NoArgsConstructor;
import model.BaseResponse;

@NoArgsConstructor
@lombok.Data
public class QueryOrderRes extends BaseResponse {

    @JSONField(name = "data")
    private Data data;

    @NoArgsConstructor
    @lombok.Data
    public static class Data {
        @JSONField(name = "order_id")
        private String orderId;
        @JSONField(name = "status")
        private String status;
        @JSONField(name = "message")
        private String message;
        @JSONField(name = "account")
        private String account;
        @JSONField(name = "amount")
        private String amount;
        @JSONField(name = "number")
        private String number;
        @JSONField(name = "create_time")
        private String createTime;
        @JSONField(name = "update_time")
        private String updateTime;
        @JSONField(name = "order_type")
        private String orderType;
    }
}
