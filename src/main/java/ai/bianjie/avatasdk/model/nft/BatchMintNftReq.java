package ai.bianjie.avatasdk.model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 批量发行nft：request
 */
@NoArgsConstructor
@Data
public class BatchMintNftReq {
    @JSONField(name = "name")
    private String name;// NFT 名称
    @JSONField(name = "uri")
    private String uri;// 链外数据链接
    @JSONField(name = "uri_hash")
    private String uriHash;// 链外数据 Hash
    @JSONField(name = "data")
    private String data;// 自定义链上元数据
    @JSONField(name = "recipients")
    private List<RecipientsDTO> recipients;// NFT 接收者地址和发行数量。以数组的方式进行组合，可以自定义多个组合，可面向多地址批量发行 NFT。
    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID，保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成的、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串

    @NoArgsConstructor
    @Data
    public static class RecipientsDTO {
        @JSONField(name = "amount")
        private Integer amount;// NFT 发行数量
        @JSONField(name = "recipient")
        private String recipient;// NFT 接收者地址，支持任一文昌链合法链账户地址。
    }
}
