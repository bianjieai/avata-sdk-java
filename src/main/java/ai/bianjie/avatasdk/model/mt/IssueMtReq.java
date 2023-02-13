package ai.bianjie.avatasdk.model.mt;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发行 MT 请求参数
 */
@NoArgsConstructor
@Data
public class IssueMtReq {

    @JSONField(name = "data")
    private String data;// 自定义链上元数据
    @JSONField(name = "amount")
    private Integer amount;// MT 数量，不填写数量时，默认发行数量为 1
    @JSONField(name = "recipient")
    private String recipient;// MT 接收者地址，支持任一文昌链合法链账户地址，默认为 MT 类别的权属者地址
    @JSONField(name = "operation_id")
    private String operationId;// 操作 ID，保证幂等性，避免重复请求，保证对于同一操作发起的一次请求或者多次请求的结果是一致的；由接入方生成的、针对每个 Project ID 唯一的、不超过 64 个大小写字母、数字、-、下划线的字符串
}
