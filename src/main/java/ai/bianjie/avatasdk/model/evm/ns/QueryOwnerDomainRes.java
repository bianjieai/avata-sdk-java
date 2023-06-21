package ai.bianjie.avatasdk.model.evm.ns;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 请求查询域名接口正确返回值
 */
@NoArgsConstructor
@Data
public class QueryOwnerDomainRes {

    @JSONField(name = "data")
    private dataDTO data;

    @NoArgsConstructor
    @Data
    public static class dataDTO {
        @JSONField(name = "domains")
        private List<QueryDomainRes.DomainsDTO> domainsDTO;

        @JSONField(name = "prev_page_key")
        private String prevPageKey;// 上一页数据的Key， Avata会根据该值进行上一页数据的查询

        @JSONField(name = "next_page_key")
        private String nextPageKey;// 下一页数据的Key， Avata会根据该值进行上一页数据的查询

        @JSONField(name = "limit")
        private Integer limit;// 每页记录数

        @JSONField(name = "total_count")
        private Integer totalCount;// 总记录数
    }
}
