package ai.bianjie.avatasdk.model.evm.contract;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询合约请求体
 */
@NoArgsConstructor
@Data
public class QueryContractCallReq {
    @JSONField(name = "to")
    private String to;// 合约地址

    @JSONField(name = "data")
    private String data;// ABI 编码待签名交易的 hex 字符串
}
