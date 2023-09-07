package ai.bianjie.avatasdktest;

import ai.bianjie.avatasdk.util.CallBackUtils;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import static ai.bianjie.avatasdk.util.CallBackUtils.APIVersionV1;

public class CallBackTest {
    public String callBack(HttpServletRequest r) throws IOException {
        try {
            String result = CallBackUtils.onCallback(APIVersionV1, "", null, r, new CallBackUtils.APP() {
                @Override
                public void app(HttpServletRequest r, String version, String apiSecret, String path) throws Exception {
                    System.out.println(version);
                    System.out.println(apiSecret);
                    System.out.println(path);
                    System.out.println(r.getHeader("X-Signature"));
                    System.out.println(r.getHeader("X-Timestamp"));
                    // Add your app logic here
                    // throw new RuntimeException("error occurred in the app method");
                }
            });
            if (result.equals("SUCCESS")) {
                System.out.println("回调推送成功");
            } else
                System.out.println("回调推送失败");
            return result; // 向 Avata 服务器返回结果
        } catch (Exception e) {
            e.printStackTrace();
            return "FAILED"; // 向 Avata 服务器返回结果
        }
    }
}


