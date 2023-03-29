package ai.bianjie.avatasdk.model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建 NFT 类别：request
 */
@NoArgsConstructor
@Data
public class CreateNftClassReq {
    @JSONField(name = "name")
    private String name;// NFT 类别名称
    @JSONField(name = "editable_by_owner")
    private Integer editableByOwner;// NFT 类别权限的控制功能， 此类别下某一 NFT 的持有者可以编辑该 NFT 1 0
    @JSONField(name = "editable_by_class_owner")
    private Integer editableByClassOwner;// NFT 类别权限的控制功能， 此 NFT 类别的权属者可以编辑这个类别下所有的 NFT 1 0
    @JSONField(name = "symbol")
    private String symbol;// 标识
    @JSONField(name = "uri")
    private String uri;// 链外数据链接
    @JSONField(name = "owner")
    private String owner;// NFT 类别权属者地址，拥有在该 NFT 类别中发行 NFT 的权限和转让该 NFT 类别的权限。 支持任一 Avata 平台内合法链账户地址
    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID，保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成的、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串
}
