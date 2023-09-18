package ai.bianjie.avatasdk.model.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新用户请求体
 */
@NoArgsConstructor
@Data
public class UpdateUserReq {

    @JSONField(name = "user_id")
    private String userId;// 用户唯一标识

    @JSONField(name = "phone_num")
    private String phoneNum;// 手机号
}
