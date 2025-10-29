package ai.bianjie.avatasdk.model.user;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 认证钱包用户请求体
 */
@NoArgsConstructor
@Data
public class KycUserReq {
    @JSONField(name = "user_type")
    private Integer userType;// 用户类型，对应创建的钱包用户的类型属性 Enum: 1(个人用户)、2(企业/机构用户)

    @JSONField(name = "user_id")
    private String userId;// 用户唯一标识

    @JSONField(name = "name")
    private String name; // 用户名或者企业名称，支持汉字以及大小写字母、空格

    @JSONField(name = "region")
    private Integer region;// 所属 国家/地区 Enum：1：其他 2：中国大陆（默认） 3：中国香港 4：中国台湾

    @JSONField(name = "certificate_type")
    private Integer certificateType;// 用户证件类型 Enum:1：身份证（默认） 2：护照

    @JSONField(name = "certificate_num")
    private String certificateNum;// 用户证件号码

    @JSONField(name = "registration_region")
    private Integer registrationRegion;// 企业注册地址 Enum: 1：其他 2：中国大陆（默认） 3：中国香港 4：中国台湾

    @JSONField(name = "registration_num")
    private String registrationNum;// 企业的统一社会信用代码或机构注册号

    @JSONField(name = "business_license")
    private String businessLicense;// 营业执照或认证授权人声明书

    @JSONField(name = "email")
    private String email;// 企业邮箱，不支持汉字以及非规范性特殊字符
}
