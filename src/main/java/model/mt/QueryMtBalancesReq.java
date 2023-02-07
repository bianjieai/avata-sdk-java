package model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询 MT 余额请求参数
 */
@NoArgsConstructor
@Data
public class QueryMtBalancesReq {
    @JSONField(name = "offset")
    private Integer offset;// 游标，默认为 0
    @JSONField(name = "limit")
    private Integer limit;// 每页记录数，默认为 10，上限为 50
    @JSONField(name = "id")
    private Integer id;// MT ID
}
