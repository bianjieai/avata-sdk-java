package ai.bianjie.avatasdk.model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建 NFT 类别请求体
 */
@NoArgsConstructor
@Data
public class CreateNftClassReq {

    @JSONField(name = "name")
    private String name;// NFT 类别名称，由创建者自定义

    @JSONField(name = "uri")
    private String uri;// 指该 NFT 类别在链外的元数据存储地址或其他链外资源的标识，元数据规范建议参考：https://forum.avata.bianjie.ai/t/topic/81

    @JSONField(name = "symbol")
    private String symbol;// NFT 类别标识，用于快速识别和查询该类 NFT 资产

    @JSONField(name = "owner")
    private String owner;// NFT 类别权属者地址，拥有在该 NFT 类别中发行 NFT 的权限。 支持任一 Avata 平台内合法链账户地址（Hex 格式）

    @JSONField(name = "editable_by_owner")
    private Integer editableByOwner;// NFT 类别权限的控制功能， 此类别下某一 NFT 的持有者可以编辑该 NFT, 1:可编辑, 0:不可编辑

    @JSONField(name = "editable_by_class_owner")
    private Integer editableByClassOwner;// NFT 类别权限的控制功能， 此 NFT 类别的权属者可以编辑这个类别下所有的 NFT, 1:可编辑, 0:不可编辑

    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID，保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成的、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串
}
