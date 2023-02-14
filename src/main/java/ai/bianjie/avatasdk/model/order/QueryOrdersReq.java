package ai.bianjie.avatasdk.model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询能量值/业务费购买结果列表接口请求参数
 */
@NoArgsConstructor
@Data
public class QueryOrdersReq {
    @JSONField(name = "offset")
    private String offset;// 游标，默认为 0
    @JSONField(name = "limit")
    private String limit;// 每页记录数，默认为 10，上限为 50
    @JSONField(name = "status")
    private String status;// 订单状态：success 充值成功 / failed 充值失败 / pending 正在充值
    @JSONField(name = "start_date")
    private String startDate;// 充值订单创建日期范围 - 开始，yyyy-MM-dd（UTC 时间）
    @JSONField(name = "end_date")
    private String endDate;// 充值订单创建日期范围 - 结束，yyyy-MM-dd（UTC 时间）
    @JSONField(name = "sort_by")
    private String sortBy;// 排序规则：DATE_ASC / DATE_DESC，默认为 DATE_DESC
}
