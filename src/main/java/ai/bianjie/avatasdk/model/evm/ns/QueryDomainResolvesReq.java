package ai.bianjie.avatasdk.model.evm.ns;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询域名解析接口请求体
 */
@NoArgsConstructor
@Data
public class QueryDomainResolvesReq {

    @JSONField(name = "resolve_type")
    private Integer resolveType;// 域名解析类型 0：全部 1：链账户 2：文本
}