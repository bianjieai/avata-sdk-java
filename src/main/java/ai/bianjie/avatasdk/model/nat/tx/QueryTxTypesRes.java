package ai.bianjie.avatasdk.model.nat.tx;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 枚举值列表查询
 */

@NoArgsConstructor
@Data
public class QueryTxTypesRes {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {

        @JSONField(name = "data")
        private List<DataDTO1> data;

        @NoArgsConstructor
        @Data
        public static class DataDTO1 {

            @JSONField(name = "module")
            private Integer module;// 交易模块

            @JSONField(name = "operation")
            private Integer operation;// 操作类型

            @JSONField(name = "code")
            private String code;// 标识

            @JSONField(name = "name")
            private String name;// 名称

            @JSONField(name = "description")
            private String description;// 描述
        }
    }
}
