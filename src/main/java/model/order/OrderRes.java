package model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

/**
 * 购买能量值/业务费接口返回值/批量购买能量值接口返回值
 */
@NoArgsConstructor
@Data
public class OrderRes extends BaseResponse {
    @JSONField(name = "data")
    private OrderRes.DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "order_id")
        private String orderId;// 交易流水号（用户发起交易时传入的交易流水号)
    }
}
