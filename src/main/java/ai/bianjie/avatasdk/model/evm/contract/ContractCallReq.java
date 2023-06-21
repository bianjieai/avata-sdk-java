package ai.bianjie.avatasdk.model.evm.contract;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 调用合约请求体
 */
@NoArgsConstructor
@Data
public class ContractCallReq {

    @JSONField(name = "from")
    private String from;// 签名交易链账户地址

    @JSONField(name = "to")
    private String to;// 合约地址

    @JSONField(name = "data")
    private String data;// ABI 编码待签名交易的 hex 字符串

    @JSONField(name = "gas_limit")
    private Integer gasLimit;// gas 使用上限大小

    @JSONField(name = "estimation")
    private Integer estimation;// 是否模拟执行交易 0 不模拟 1 模拟

    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID
}
