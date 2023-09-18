package ai.bianjie.avatasdk.model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询能量值购买结果列表接口请求体
 */
@NoArgsConstructor
@Data
public class QueryOrdersReq {

    @JSONField(name = "page_key")
    private String pageKey;// 分页数据的Key， Avata会根据该值进行上下页的查询， 该值请从返回的数据体中获取，首页查询可以不传该参数

    @JSONField(name = "limit")
    private String limit;// 每页记录数，默认为 10，上限为 50

    @JSONField(name = "status")
    private String status;// 订单状态: 1 正在充值；2 充值成功；3 充值失败；

    @JSONField(name = "start_date")
    private String startDate;// 充值订单创建日期范围 - 开始，yyyy-MM-dd（UTC 时间）

    @JSONField(name = "end_date")
    private String endDate;// 充值订单创建日期范围 - 结束，yyyy-MM-dd（UTC 时间）

    @JSONField(name = "sort_by")
    private String sortBy;// 排序规则：DATE_ASC / DATE_DESC，默认为 DATE_DESC

    @JSONField(name = "count_total")
    private String countTotal;// 是否查询数据的总数量 0：不查询总数（默认） 1：查询总数
}
