package ai.bianjie.avatasdktest;

import ai.bianjie.avatasdk.util.CallBackUtils;
import org.junit.jupiter.api.Test;

public class CallBackTest {
    @Test
    // 测试 V1 版本回调
    public void callBackV1() {
        String body = "Avata 推送的消息 body";
        String signature = "Avata 推送的消息的签名";
        String apiSecret = "API 项目 Secret";
        // 实现业务接口
        Business business = new Business();
        String res = CallBackUtils.callBackV1(body, signature, apiSecret, business);
        System.out.println(res);
    }


    @Test
    // 测试 V2 以其以上版本版本回调
    public void callBack() {
        String path = "回调地址（去掉域名）";
        String body = "Avata 推送的消息 body";
        Long timeStamp = 1693387882000L;// Avata 推送的消息时间戳
        String signature = "Avata 推送的消息的签名";
        String apiSecret = "API 项目 Secret";
        // 实现业务接口
        Business business = new Business();
        String res = CallBackUtils.callBack(path, body, timeStamp, apiSecret, signature, business);
        System.out.println(res);
    }
}

// 实现业务逻辑类
class Business implements CallBackUtils.Business {
    @Override
    public void businessV1(String body, String signature, String apiSecret) {
        // 在此实现业务逻辑
        System.out.println("在此实现业务逻辑");
        System.out.println(body);
        System.out.println(signature);
        System.out.println(apiSecret);
    }

    @Override
    public void business(String path, String body, Long timeStamp, String apiSecret, String signature) {
        // 在此实现业务逻辑
        System.out.println("在此实现业务逻辑");
        System.out.println(path);
        System.out.println(body);
        System.out.println(timeStamp);
        System.out.println(apiSecret);
        System.out.println(signature);
    }
}