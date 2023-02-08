package model.tx;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 上链交易排队状态查询请求参数
 */
@NoArgsConstructor
@Data
public class QueryQueueReq {
    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID，是指用户在进行具体的NFT/MT/业务接口请求时，自定义的操作ID。注意：不支持创建链账户/批量创建链账户的操作 ID 查询。
}
