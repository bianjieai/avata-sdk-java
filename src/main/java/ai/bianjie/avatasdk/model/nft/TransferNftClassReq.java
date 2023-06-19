package ai.bianjie.avatasdk.model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 转让 NFT 类别请求体
 */
@NoArgsConstructor
@Data
public class TransferNftClassReq {

    @JSONField(name = "recipient")
    private String recipient;// NFT 合约接收者地址，支持任一 Avata 平台内合法链账户地址（Hex 格式）

    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID，保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成的、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串

}
