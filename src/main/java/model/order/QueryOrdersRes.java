package model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.List;
@NoArgsConstructor
@Data
public class QueryOrdersRes extends BaseResponse {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "offset")
        private int offset;
        @JSONField(name = "limit")
        private int limit;
        @JSONField(name = "total_count")
        private int totalCount;
        @JSONField(name = "order_infos")
        private List<OrderInfos> orderInfos;

        @NoArgsConstructor
        @Data
        public static class OrderInfos {
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
}
