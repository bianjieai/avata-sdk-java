package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QueryMtBalancesReq {
    @JSONField(name = "offset")
    private Integer offset;
    @JSONField(name = "limit")
    private Integer limit;
    @JSONField(name = "id")
    private Integer id;
}
