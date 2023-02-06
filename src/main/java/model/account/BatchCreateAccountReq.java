package model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 批量创建链账户请求体
 *
 * @author sxj
 */
@NoArgsConstructor
@Data
public class BatchCreateAccountReq {

    @JSONField(name = "count")
    private Integer count;
    @JSONField(name = "operation_id")
    private String operationId;
}
