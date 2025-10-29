package ai.bianjie.avatasdk.model.evm.nft;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发行 NFT 请求体
 */
@NoArgsConstructor
@Data
public class MintNftReq {

    @JSONField(name = "uri")
    private String uri;// 指该 NFT 在链外的元数据存储地址或其他链外资源的标识 元数据规范建议参考：https://forum.avata.bianjie.ai/t/topic/81

    @JSONField(name = "uri_hash")
    private String uriHash;// 指通过某种哈希算法将链外元数据进行数字化加密处理后，得到的哈希值

    @JSONField(name = "recipient")
    private String recipient;// NFT 接收者地址，支持任一文昌链合法链账户地址，默认为 NFT 类别的权属者地址（Hex 格式）

    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID，保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成的、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串
}
