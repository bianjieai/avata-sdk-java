package ai.bianjie.avatasdk.model.user;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建用户正确返回值
 */
@NoArgsConstructor
@Data
public class CreateUserRes {

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
