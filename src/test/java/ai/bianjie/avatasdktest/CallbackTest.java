package ai.bianjie.avatasdktest;

import ai.bianjie.avatasdk.util.CallbackUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;

import static ai.bianjie.avatasdk.model.onCallbackRes.*;

public class CallbackTest {
    public String callback(HttpServletRequest r) {
        try {
            String result = CallbackUtils.OnCallback(APIVersionV1, "", null, r, new CallbackUtils.APP() {
                @Override
                public void onCallback(String version, String kind, Object object) throws Exception {
                    System.out.println(version);
                    System.out.println(r.getHeader("X-Signature"));
                    System.out.println(r.getHeader("X-Timestamp"));
                    // Add your app logic here
                    //throw new CallbackUtils.AppException("error occurred in the app method");
                    if (object instanceof onCallbackResV1) {
                        // V1 版本回调结果
                        onCallbackResV1 v1Res = (onCallbackResV1) object;
                        System.out.println(v1Res);

                        Object nftObj = JSON.parseObject(v1Res.getNft(), NftV1.class);
                        NftV1 nftRes = (NftV1) nftObj;
                        System.out.println(nftRes.getClassId());

                    } else if (object instanceof onCallbackResNative) {
                        // V2 及以上版本原生模块接口回调结果
                        onCallbackResNative nativeRes = (onCallbackResNative) object;
                        System.out.println(nativeRes.getNft().getId());
                    } else if (object instanceof onCallbackResEVM) {
                        // V2 及以上版本 EVM 模块接口回调结果
                        onCallbackResEVM evmRes = (onCallbackResEVM) object;
                        System.out.println(evmRes.getNft().getId());
                    } else {
                        // 处理其他类型或默认情况
                        throw new Exception("Object is of unknown type");
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


