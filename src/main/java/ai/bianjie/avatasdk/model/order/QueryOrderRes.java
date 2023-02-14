package ai.bianjie.avatasdk.model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.NoArgsConstructor;

/**
 * 查询能量值/业务费购买结果接口返回值
 */
@NoArgsConstructor
@lombok.Data
public class QueryOrderRes {

    @JSONField(name = "data")
    private Data data;

    @NoArgsConstructor
    @lombok.Data
    public static class Data {
        @JSONField(name = "order_id")
        private String orderId;// 订单流水号
        @JSONField(name = "status")
        private String status;// 订单状态：success 充值成功 / failed 充值失败 / pending 正在充值
        @JSONField(name = "message")
        private String message;// 订单失败的错误描述信息
        @JSONField(name = "account")
        private String account;// 链账户地址 （调用「批量购买能量值」接口不展示此字段）
        @JSONField(name = "amount")
        private String amount;// 充值金额，为整数元金额；单位：分 （调用「批量购买能量值」接口不展示此字段）
        @JSONField(name = "number")
        private String number;// 充值的数量，充值 gas 该值单位为 ugas，充值业务费单位为分（调用「批量购买能量值」接口不展示此字段）
        @JSONField(name = "create_time")
        private String createTime;// 创建时间（UTC 时间）
        @JSONField(name = "update_time")
        private String updateTime;// 最后操作时间（UTC 时间）
        @JSONField(name = "order_type")
        private String orderType;// 订单类型，gas / business
    }
}
