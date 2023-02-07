package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发行 NFT：request
 */
@NoArgsConstructor
@Data
public class MintNftReq {

    @JSONField(name = "name")
    private String name;// NFT 名称
    @JSONField(name = "uri")
    private String uri;// 链外数据链接
    @JSONField(name = "uri_hash")
    private String uriHash;// 链外数据 Hash
    @JSONField(name = "data")
    private String data;// 自定义链上元数据
    @JSONField(name = "recipient")
    private String recipient;// NFT 接收者地址，支持任一文昌链合法链账户地址，默认为 NFT 类别的权属者地址
    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID，保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成的、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串
}
