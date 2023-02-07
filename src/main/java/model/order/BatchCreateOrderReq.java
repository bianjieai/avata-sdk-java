package model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 批量购买能量值接口请求参数
 */
@NoArgsConstructor
@Data
public class BatchCreateOrderReq {

    @JSONField(name = "list")
    private List<ListDTO> list;// 充值信息
    @JSONField(name = "order_id")
    private String orderId;// 自定义订单流水号，必需且仅包含数字、下划线及英文字母大/小写

    @NoArgsConstructor
    @Data
    public static class ListDTO {
        @JSONField(name = "account")
        private String account;// 链账户地址
        @JSONField(name = "amount")
        private Integer amount;// 购买金额 ，只能购买整数元金额；单位：分
    }
}
