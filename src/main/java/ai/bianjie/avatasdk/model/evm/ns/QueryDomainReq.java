package ai.bianjie.avatasdk.model.evm.ns;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询域名接口请求体
 */
@NoArgsConstructor
@Data
public class QueryDomainReq {

    @JSONField(name = "name")
    private String name;// 域名关键字，包含大小写英文字母、阿拉伯数字和连字符 -

    @JSONField(name = "tld")
    private String tld;// 根域名。文昌链目前支持的一级根域名有：【.w】、【.dao】、【.meta】、【.id】、【.wallet】
}
