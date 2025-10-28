package ai.bianjie.avatasdktest;

import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.user.*;
import ai.bianjie.avatasdk.util.AvataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private AvataClient client;

    @BeforeEach
    public void init() {
        client = AvataClientTest.getAvataClient();
    }

    @Test
        //请求创建钱包用户接口示例
    void TestCreateUser() {
        CreateUserReq req = new CreateUserReq();
        // 创建普通用户
        //req.setPhoneNum("");

        // 创建个人用户
        //req.setUserType(1);
        //req.setName();
        //req.setRegion();
        //req.setCertificateType();
        //req.setCertificateNum("");
        //req.setPhoneNum("");

        // 创建企业/机构用户
        //req.setUserType(2);
        //req.setName("");
        //req.setRegistrationRegion();
        //req.setRegistrationNum("");
        //req.setPhoneNum("");
        //req.setBusinessLicense("");
        //req.setEmail("");
        try {
            CreateUserRes user = client.user.createUser(req);
            System.out.println(user.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求更新钱包用户接口示例
    void TestUpdateUser() {
        UpdateUserReq req = new UpdateUserReq();
        req.setUserId("");
        req.setPhoneNum("");
        try {
            PublicResponse user = client.user.updateUser(req);
            System.out.println(user.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求认证钱包用户接口示例
    void TestKycUser() {
        KycUserReq req = new KycUserReq();
        // 认证为个人用户
        //req.setUserType(1);
        //req.setUserId("");
        //req.setName("");
        //req.setRegion();
        //req.setCertificateType();
        //req.setCertificateNum("");

        // 认证为企业用户
        //req.setUserType(2);
        //req.setUserId("");
        //req.setName("");
        //req.setRegistrationRegion();
        //req.setRegistrationNum("");
        //req.setBusinessLicense("");
        //req.setEmail("");
        try {
            PublicResponse user = client.user.kycUser(req);
            System.out.println(user.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }


    @Test
        //请求查询钱包用户信息接口示例
    void TestQueryUser() {
        QueryUserReq req = new QueryUserReq();
        req.setPhoneNum(AvataUtils.sha256Sum(""));// 创建钱包用户时，填入的手机号
        req.setUserType("");
        //user_type为 "1" 时，请填写提交认证时对应的个人信息（身份证或护照号）
        //user_type为 "2" 时，请填写提交认证时对应的企业信息（企业的统一社会信用代码或机构注册号）
        req.setCode(AvataUtils.sha256Sum(""));
        try {
            QueryUserRes user = client.user.queryUser(req);
            System.out.println(user.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}