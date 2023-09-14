package ai.bianjie.avatasdktest;

import ai.bianjie.avatasdk.util.CallbackUtils;

import javax.servlet.http.HttpServletRequest;

import static ai.bianjie.avatasdk.model.onCallbackRes.*;

public class CallbackTest {
    public String callback(HttpServletRequest r) {
        try {
            String result = CallbackUtils.OnCallback(APIVersionV1, "", null, r, new CallbackUtils.APP() {
                @Override
                public void app(HttpServletRequest r, String version, String apiSecret, String path, Object object) {
                    System.out.println(version);
                    System.out.println(apiSecret);
                    System.out.println(path);
                    System.out.println(r.getHeader("X-Signature"));
                    System.out.println(r.getHeader("X-Timestamp"));
                    // Add your app logic here
                    //throw new CallbackUtils.AppException("error occurred in the app method");
                    switch (object.getClass().getName()) {
                        case "onCallbackResV1":
                            onCallbackResV1 v1Res = (onCallbackResV1) object;
                            System.out.println(v1Res.getTxHash());
                            break;
                        case "onCallbackResNative":
                            onCallbackResNative nativeRes = (onCallbackResNative) object;
                            System.out.println(nativeRes.getTxHash());
                            break;
                        case "onCallbackResEVM":
                            onCallbackResEVM evmRes = (onCallbackResEVM) object;
                            System.out.println(evmRes.getTxHash());
                            break;
                        default:
                            // 处理其他类型或默认情况
                            System.out.println("Object is of unknown type");
                    }
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


