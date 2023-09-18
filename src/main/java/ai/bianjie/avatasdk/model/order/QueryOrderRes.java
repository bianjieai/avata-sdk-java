package ai.bianjie.avatasdk.model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询能量值购买结果接口正确返回值
 *
 * 订单状态说明：
 * status 为 1（正在充值），请等待充值完成；
 * status 为 2（充值成功），能量值/业务费充值成功；
 * status 为 3（充值失败），说明该交易执行失败。请在业务侧做容错处理。可以参考接口返回的 message（订单失败的错误描述信息） 对业务接口的请求参数做适当调整后，使用「新的 Operation ID 」重新发起业务接口请求。
 */
@NoArgsConstructor
@Data
public class QueryOrderRes {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "operation_id")
        private String operationId;// 操作 ID，保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成并自行维护、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串组成。

        @JSONField(name = "status")
        private Integer status;// 订单状态：1 正在充值；2 充值成功；3 充值失败

        @JSONField(name = "message")
        private String message;// 订单失败的错误描述信息

        @JSONField(name = "account")
        private String account;// 链账户地址 （调用「批量购买能量值」接口不展示此字段）

        @JSONField(name = "amount")
        private String amount;// 充值金额，为整数元金额；单位：分 （调用「批量购买能量值」接口不展示此字段）

        @JSONField(name = "number")
        private String number;// 充值的数量，充值 gas 该值单位为 ugas（调用「批量购买能量值」接口不展示此字段）

        @JSONField(name = "create_time")
        private String createTime;// 创建时间（UTC 时间）

        @JSONField(name = "update_time")
        private String updateTime;// 最后操作时间（UTC 时间）

        @JSONField(name = "order_type")
        private Integer orderType;// 订单类型 1 gas，能量值；
    }
}
