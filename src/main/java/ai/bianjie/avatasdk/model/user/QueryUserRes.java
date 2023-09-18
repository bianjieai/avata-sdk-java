package ai.bianjie.avatasdk.model.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询用户正确返回值
 */
@NoArgsConstructor
@Data
public class QueryUserRes {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {

        @JSONField(name = "user_id")
        private String userId;// 用户唯一标识

        @JSONField(name = "did")
        private String did;// 用户身份标识(预留字段)
    }
}
