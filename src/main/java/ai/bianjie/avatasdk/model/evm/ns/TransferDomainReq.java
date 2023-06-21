package ai.bianjie.avatasdk.model.evm.ns;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TransferDomainReq {

    @JSONField(name = "recipient")
    private String recipient;// 域名接收者地址，支持任一Avata 内托管的地址

    @JSONField(name = "operation_id")
    private String operationId;// 操作ID，保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成并自行维护、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串
}
