package ai.bianjie.avatasdk.model.evm.ns;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询域名反向解析接口正确返回值
 */
@NoArgsConstructor
@Data
public class QueryReverseResolveDomainRes {
    @JSONField(name = "data")
    private dataDTO data;

    @NoArgsConstructor
    @Data
    public static class dataDTO {
        @JSONField(name = "name")
        private String name; // 域名
    }
}
