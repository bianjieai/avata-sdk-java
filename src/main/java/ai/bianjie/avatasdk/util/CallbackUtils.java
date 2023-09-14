package ai.bianjie.avatasdk.util;

import ai.bianjie.avatasdk.model.onCallbackRes;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import static ai.bianjie.avatasdk.util.AvataUtils.sha256Sum;
import static ai.bianjie.avatasdk.util.AvataUtils.sign;
import static ai.bianjie.avatasdk.model.onCallbackRes.*;

public class CallbackUtils {

    /**
     * v1 版本签名回调验签
     */
    public static boolean callbackV1(HttpServletRequest r, String apiSecret) {
        try {
            String signature = r.getHeader("X-Signature");
            JSONObject jsonObj = JSON.parseObject(getRequestBody(r).toString());
            String jsonStr = JSON.toJSONString(jsonObj, SerializerFeature.MapSortField);
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
    public static boolean callback(HttpServletRequest r, String path, String apiSecret) {
        try {
            String signature = r.getHeader("X-Signature");
            Long timestamp = Long.valueOf(r.getHeader("X-Timestamp"));
            String hexHash = sign(path, null, getRequestBody(r), timestamp, apiSecret);
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
     * @param version   版本 ：v1 需要传 APIVersionV1 , v2 或者 v3 版本传 APIVersionsOther
     * @param apiSecret 项目 API Secret
     * @param path      在 Avata服务平台设置的回调地址(去掉域名)
     * @param r         该笔推送消息属于文昌链上链完成所推送消息，请及时存储数据
     * @param app       自己的业务逻辑代码（验证签名通过才会执行）
     * @return
     * @throws Exception
     */
    public static String OnCallback(String version, String apiSecret, String path, HttpServletRequest r, APP app) throws Exception {
        Object obj = null;

        boolean result;
        switch (version) {
            case APIVersionV1:
                result = callbackV1(r, apiSecret);
                // 获取请求体的 Reader
                BufferedReader reader = r.getReader();
                StringBuilder body = new StringBuilder();

                // 读取请求体内容
                String line;
                while ((line = reader.readLine()) != null) {
                    body.append(line);
                }

                // 请求体内容存储在 body 变量中
                String requestBody = body.toString();
                obj = JSON.parseObject(requestBody, onCallbackRes.onCallbackResV1.class);
                break;
            case APIVersionsOther:
                result = callback(r, path, apiSecret);
                break;
            default:
                // 版本不对，报错版本验证失败
                throw new Exception("version verification failed");
        }
        if (!result) {
            // 回调推送签名验证失败
            throw new Exception("signature verification failed");
        }

        // 该笔推送消息属于文昌链上链完成所推送消息，请及时存储数据
        try {
            app.app(r, version, apiSecret, path, obj);
        } catch (Exception e) {
            // 业务接口异常
            throw new Exception("app error: " + e.getMessage());
        }
        // 向 Avata 服务器返回结果
        return "SUCCESS";
    }

    private static Map<String, Object> getRequestBody(HttpServletRequest r) {
        StringBuilder requestBody = new StringBuilder();
        try {
            BufferedReader reader = r.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        Map<String, Object> maps = JSON.parseObject(String.valueOf(requestBody));
        //System.out.println("Request Body: " + requestBody);
        return maps;
    }

    /**
     * 业务接口，应用方需要实现业务逻辑，在验签成功后执行
     */
    public interface APP {
        void app(HttpServletRequest r, String version, String apiSecret, String path, Object object);
    }

}



