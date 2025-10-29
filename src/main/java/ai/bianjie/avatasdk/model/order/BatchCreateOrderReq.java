package ai.bianjie.avatasdk.model.order;

import com.alibaba.fastjson2.annotation.JSONField;
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

    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID，保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成并自行维护、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串组成。

    @NoArgsConstructor
    @Data
    public static class ListDTO {

        @JSONField(name = "account")
        private String account;// 链账户地址

        @JSONField(name = "amount")
        private Integer amount;// 购买金额 ，只能购买整数元金额；单位：分
    }
}
