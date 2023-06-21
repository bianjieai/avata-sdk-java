package ai.bianjie.avatasdk.model.evm.ns;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 注册域名接口请求体
 */
@NoArgsConstructor
@Data
public class RegisterDomainReq {
    @JSONField(name = "name")
    private String name; // 一级域名，包含大小写英文字母、阿拉伯数字和连字符 -

    @JSONField(name = "owner")
    private String owner;// 域名拥有者的链账户地址，支持任一 Avata 内托管的地址

    @JSONField(name = "duration")
    private Integer duration;// 购买年限，Enum：1,2,3,4,5

    @JSONField(name = "operation_id")
    private String operationId;// 保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成并自行维护、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串
}
