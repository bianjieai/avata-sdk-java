package ai.bianjie.avatasdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询链账户请求体
 */
@NoArgsConstructor
@Data
public class QueryAccountsReq {
    @JSONField(name = "page_key")
    private String pageKey;// 分页数据的Key， Avata会根据该值进行上下页的查询， 该值请从返回的数据体中获取，首页查询可以不传该参数

    @JSONField(name = "limit")
    private String limit;// 每页记录数，默认为 10，上限为 50

    @JSONField(name = "user_id")
    private String userId;// 钱包应用项目在创建链账户地址时传入的字段，方便查询某一终端用户的链账户地址信息。该字段值由创建用户接口返回

    @JSONField(name = "account")
    private String account;// 链账户地址

    @JSONField(name = "name")
    private String name;// 链账户名称，支持模糊查询

    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID。此操作 ID 需要填写在请求创建链账户/批量创建链账户接口时，返回的 Operation ID。

    @JSONField(name = "start_date")
    private String startDate;// 创建日期范围 - 开始，yyyy-MM-dd（UTC 时间）

    @JSONField(name = "end_date")
    private String endDate;// 创建日期范围 - 结束，yyyy-MM-dd（UTC 时间）

    @JSONField(name = "sort_by")
    private String sortBy;// 排序规则：DATE_ASC / DATE_DESC

    @JSONField(name = "count_total")
    private String countTotal; // 是否查询数据的总数量 0：不查询总数（默认） 1：查询总数
}
