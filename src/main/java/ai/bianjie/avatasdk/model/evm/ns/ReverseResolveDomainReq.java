package ai.bianjie.avatasdk.model.evm.ns;

import com.alibaba.fastjson.annotation.JSONField;
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
}
