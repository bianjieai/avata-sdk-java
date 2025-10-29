package ai.bianjie.avatasdk.model.evm.ns;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 设置域名反向解析接口请求体
 */
@NoArgsConstructor
@Data
public class ReverseResolveDomainReq {
    @JSONField(name = "name")
    private String name; // 域名名称

    @JSONField(name = "operation_id")
    private String operationId; // 保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成并自行维护、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串
}
