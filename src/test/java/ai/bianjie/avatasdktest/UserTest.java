package ai.bianjie.avatasdktest;

import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.user.*;
import ai.bianjie.avatasdk.util.AvataUtils;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
        //请求创建用户接口示例
    void TestCreateUser() {
        CreateUserReq req = new CreateUserReq();
        req.setUserType(1);
        req.setName("");
        req.setCertificateNum("");
        req.setPhoneNum("");
        try {
            CreateUserRes user = AvataClientTest.getAvataClient().userClient.createUser(req);
            System.out.println(user.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求更新用户接口示例
    void TestUpdateUser() {
        UpdateUserReq req = new UpdateUserReq();
        req.setUserId("");
        req.setPhoneNum("");
        try {
            PublicResponse user = AvataClientTest.getAvataClient().userClient.updateUser(req);
            System.out.println(user.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询用户接口示例
    void TestQueryUser() {
        QueryUserReq req = new QueryUserReq();
        // user_type为 "1" 时，请填写提交认证时对应的个人信息（身份证或护照号）
        // user_type为 "2" 时，请填写提交认证时对应的企业信息（企业的统一社会信用代码或机构注册号）
        // 📢 注意：参数需要进行 hash 操作，hash 算法为：sha-256
        String code = AvataUtils.sha256Sum("");
        req.setUserType("1");
        req.setCode(code);
        try {
            QueryUserRes user = AvataClientTest.getAvataClient().userClient.queryUser(req);
            System.out.println(user.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}