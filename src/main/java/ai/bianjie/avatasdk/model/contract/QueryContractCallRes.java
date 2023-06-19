package ai.bianjie.avatasdk.model.contract;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询合约正确返回值
 */
@NoArgsConstructor
@Data
public class QueryContractCallRes {
    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "result")
        private String result;// 合约调用结果 hex 字符串
    }
}
