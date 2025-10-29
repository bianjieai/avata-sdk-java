package ai.bianjie.avatasdk.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.Map;

import static ai.bianjie.avatasdk.util.AvataUtils.sha256Sum;
import static ai.bianjie.avatasdk.util.AvataUtils.sign;
import static ai.bianjie.avatasdk.model.onCallbackRes.*;

public class CallbackUtils {

    /**
     * v1 版本签名回调验签
     */
    public static boolean callbackV1(HttpServletRequest r, String apiSecret, String requestBodyData) {
        try {
            String signature = r.getHeader("X-Signature");
            JSONObject jsonObj = JSON.parseObject(getMap(requestBodyData).toString());
            String jsonStr = JSON.toJSONString(jsonObj, JSONWriter.Feature.SortMapEntriesByKeys);
            // 执行签名
            String hexHash = sha256Sum(jsonStr + apiSecret);
            if (!hexHash.equals(signature)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * v2 及其以上版本签名回调验签
     */
    public static boolean callback(HttpServletRequest r, String path, String apiSecret, String requestBodyData) {
        try {
            String signature = r.getHeader("X-Signature");
            Long timestamp = Long.valueOf(r.getHeader("X-Timestamp"));
            String hexHash = sign(path, null, getMap(requestBodyData), timestamp, apiSecret);
            if (!hexHash.equals(signature)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 接收来自 Avata 的推送消息
     *
     * @param version    版本 ：v1 需要传 APIVersionV1 , v2 或者 v3 版本传 APIVersionsOther
     * @param apiSecret  项目 API Secret
     * @param path       在 Avata服务平台设置的回调地址(去掉域名)
     * @param r          该笔推送消息属于文昌链上链完成所推送消息，请及时存储数据
     * @param onCallback 自己的业务逻辑代码（验证签名通过才会执行）
     * @return
     * @throws Exception
     */
    public static String OnCallback(String version, String apiSecret, String path, HttpServletRequest r, APP onCallback) throws Exception {
        String requestBodyData = getRequestBody(r);
        Object obj = null;
        String kind = "";
        boolean result;
        switch (version) {
            case APIVersionV1:
                // 验证签名
                result = callbackV1(r, apiSecret, requestBodyData);
                if (!result) {
                    // 回调推送签名验证失败
                    throw new Exception("signature verification failed");
                }
                // 解析回调结果
                obj = JSON.parseObject(requestBodyData, onCallbackResV1.class);
                break;

            case APIVersionsOther:
                //验证签名
                result = callback(r, path, apiSecret, requestBodyData);
                if (!result) {
                    // 回调推送签名验证失败
                    throw new Exception("signature verification failed");
                }
                // 根据不同的服务模块（native/evm）解析回调结果
                obj = JSON.parseObject(requestBodyData, Kind.class);
                Kind kindRes = (Kind) obj;

                switch (kindRes.getKind()) {
                    case Native:
                        kind = Native;
                        obj = JSON.parseObject(requestBodyData, onCallbackResNative.class);
                        break;
                    case EVM:
                        kind = EVM;
                        obj = JSON.parseObject(requestBodyData, onCallbackResEVM.class);
                        break;
                }
                break;
            default:
                // 版本不对，报错版本验证失败
                throw new Exception("version verification failed");
        }

        // 该笔推送消息属于文昌链上链完成所推送消息，请及时存储数据
        try {
            onCallback.onCallback(version, kind, obj);
        } catch (Exception e) {
            // 业务接口异常
            throw new Exception("app error: " + e.getMessage());
        }
        // 向 Avata 服务器返回结果
        return "SUCCESS";
    }

    /**
     * 获取 HTTP 请求体内容
     */
    public static String getRequestBody(HttpServletRequest r) {
        StringBuilder requestBody = new StringBuilder();
        try {
            BufferedReader reader = r.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // 请求体内容存储在 body 变量中
        String body = requestBody.toString();
        return body;
    }

    /**
     * JSON 格式的字符串转换为 Map 对象
     */
    public static Map<String, Object> getMap(String params) {
        Map<String, Object> maps = JSON.parseObject(params);
        return maps;
    }

    /**
     * 业务接口，应用方需要实现业务逻辑，在验签成功后执行
     */
    public interface APP {
        void onCallback(String version, String kind, Object object) throws Exception;
    }
}



