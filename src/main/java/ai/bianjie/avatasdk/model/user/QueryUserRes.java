package ai.bianjie.avatasdk.model.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询钱包用户信息正确返回值
 */
@NoArgsConstructor
@Data
public class QueryUserRes {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {

        @JSONField(name = "user_ids")
        private List<UserIdsDTO> userIds;// 用户唯一标识

        @NoArgsConstructor
        @Data
        public static class UserIdsDTO {
        }

        @JSONField(name = "did")
        private String did;// 用户身份标识(预留字段)
    }
}
