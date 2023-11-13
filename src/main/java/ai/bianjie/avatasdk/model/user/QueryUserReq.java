package ai.bianjie.avatasdk.model.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询钱包用户信息请求体
 */
@NoArgsConstructor
@Data
public class QueryUserReq {

    @JSONField(name = "phone_num")
    private String phoneNum;// 创建钱包用户时，填入的手机号。注意：参数需要进行 hash 操作，hash 算法为：sha-256

    @JSONField(name = "user_type")
    private String userType;// 用户类型， 对于创建的钱包用户的类型属性 Enum:1：个人 2：企业

    @JSONField(name = "code")
    private String code;// user_type 为 "1" 时，请填写提交认证时对应的个人信息（身份证或护照号） user_type 为 "2" 时，请填写提交认证时对应的企业信息（企业的统一社会信用代码或机构注册号）参数需要进行 hash 操作，hash 算法为：sha-256
}
