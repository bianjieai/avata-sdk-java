package model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreateOrderReq {
    @JSONField(name = "account")
    private String account;
    @JSONField(name = "amount")
    private Integer amount;
    @JSONField(name = "order_type")
    private String orderType;
    @JSONField(name = "order_id")
    private String orderId;
}
