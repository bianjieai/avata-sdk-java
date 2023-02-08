package model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 购买能量值/业务费接口请求参数
 */
@NoArgsConstructor
@Data
public class CreateOrderReq {
    @JSONField(name = "account")
    private String account;// 链账户地址
    @JSONField(name = "amount")
    private Integer amount;// 购买金额 ，只能购买整数元金额；单位：分
    @JSONField(name = "order_type")
    private String orderType;// 充值类型：gas：能量值；business：业务费；Enum: "gas" "business"
    @JSONField(name = "order_id")
    private String orderId;// 自定义订单流水号，必需且仅包含数字、下划线及英文字母大/小写
}
