package ai.bianjie.avatasdktest;

import ai.bianjie.avatasdk.util.CallBackUtils;
import org.junit.jupiter.api.Test;

import static ai.bianjie.avatasdk.util.CallBackUtils.APIVersionV1;

public class CallBackTest {
    @Test

    public void callBack() {
        //测试 V1 版本回调
        String body = "Avata 推送的消息 body";
        String signature = "Avata 推送的消息的签名";
        String apiSecret = "API 项目 Secret";

        // 测试 V2 以其以上版本回调
        //String path = "回调地址（去掉域名）";
        //String body = "Avata 推送的消息 body";
        //Long timeStamp = 1693387882000L;// Avata 推送的消息时间戳
        //String signature = "Avata 推送的消息的签名";
        //String apiSecret = "API 项目 Secret";
        String res = CallBackUtils.onCallback(APIVersionV1, body, 0L, apiSecret, signature, "", new CallBackUtils.APP() {
            @Override
            public void appV1(String body, String signature, String apiSecret) {
                System.out.println("在此实现业务逻辑");
                System.out.println(body);
                System.out.println(apiSecret);
                System.out.println(signature);
            }

            @Override
            public void app(String path, String body, Long timeStamp, String apiSecret, String signature) {
                System.out.println("在此实现业务逻辑");
                System.out.println(path);
                System.out.println(body);
                System.out.println(timeStamp);
                System.out.println(apiSecret);
                System.out.println(signature);
            }
        });
        System.out.println(res);
    }
}

