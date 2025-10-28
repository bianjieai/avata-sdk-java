package ai.bianjie.avatasdk.model.nat.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 转让 MT 类别请求参数
 */
@NoArgsConstructor
@Data
public class TransferMtClassReq {

    @JSONField(name = "recipient")
    private String recipient;// MT 类别接收者地址，支持任一 Avata 内合法链账户地址

    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID，保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成的、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串

}
