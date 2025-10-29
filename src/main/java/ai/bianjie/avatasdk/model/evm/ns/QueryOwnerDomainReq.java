package ai.bianjie.avatasdk.model.evm.ns;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求查询用户域名接口
 */
@NoArgsConstructor
@Data
public class QueryOwnerDomainReq {

    @JSONField(name = "name")
    private String name;// 域名关键字

    @JSONField(name = "tld")
    private String tld;// 根域名

    @JSONField(name = "page_key")
    private String pageKey;// 分页数据的Key， Avata会根据该值进行上下页的查询， 该值请从返回的数据体中获取，首页查询可以不传该参数

    @JSONField(name = "limit")
    private String limit;// 每页记录数，默认为 10，上限为 50

    @JSONField(name = "count_total")
    private String countTotal;// 是否查询数据的总数量, 0：不查询总数（默认）; 1：查询总数
}
