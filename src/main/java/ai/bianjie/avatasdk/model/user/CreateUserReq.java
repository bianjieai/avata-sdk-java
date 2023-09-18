package ai.bianjie.avatasdk.model.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建用户请求体
 */
@NoArgsConstructor
@Data
public class CreateUserReq {

    @JSONField(name = "user_type")
    private Integer userType;// 用户类型， 对于创建的钱包用户的类型属性 Enum:1：个人 2：企业

    @JSONField(name = "name")
    private String name; // 用户的真实姓名， 支持汉字以及大小写字母、空格

    @JSONField(name = "region")
    private Integer region;// 所属 国家/地区 Enum：1：其他 2：中国大陆（默认） 3：中国香港 4：中国台湾

    @JSONField(name = "certificate_type")
    private Integer certificateType;// 用户证件类型 Enum:1：身份证（默认） 2：护照

    @JSONField(name = "certificate_num")
    private String certificateNum;// 用户证件号码

    @JSONField(name = "phone_num")
    private String phoneNum;// 联系人或授权人手机号

    @JSONField(name = "registration_region")
    private Integer registrationRegion;// 企业注册地址 Enum: 1：其他 2：中国大陆（默认） 3：中国香港 4：中国台湾

    @JSONField(name = "registration_num")
    private String registrationNum;// 企业的统一社会信用代码或机构注册号

    @JSONField(name = "business_license")
    private String businessLicense;// 营业执照或认证授权人声明书

    @JSONField(name = "email")
    private String email;// 企业邮箱，不支持汉字以及非规范性特殊字符。
}
