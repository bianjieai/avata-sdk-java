package ai.bianjie.avatasdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建链账户请求体
 */
@NoArgsConstructor
@Data
public class CreateAccountReq {

    @JSONField(name = "name")
    private String name;// 链账户名称，支持 1-20 位汉字、大小写字母及数字组成的字符串

    @JSONField(name = "user_id")
    private String userId;// 此字段针对区块链钱包应用项目设置，通过区块链钱包给某一具体终端用户创建链账户地址时，必需传入该字段。该字段值是由「创建用户」接口返回。

    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID，保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成的、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串组成。此操作 ID 仅限在查询链账户接口中使用，用于查询创建链账户的授权状态。
}
