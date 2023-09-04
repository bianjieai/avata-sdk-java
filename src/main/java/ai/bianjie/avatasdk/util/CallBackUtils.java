package ai.bianjie.avatasdk.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Map;

import static ai.bianjie.avatasdk.util.AvataUtils.sha256Sum;
import static ai.bianjie.avatasdk.util.AvataUtils.sign;

public class CallBackUtils {

    /**
     * 如果对接的是 v1 版本，用以下方式验签
     *
     * @param body      来自 Avata API 推送的请求体参数
     * @param signature 来自 Avata API 推送的请求头的签名，算法为 SHA256 (body + ApiSecret)
     * @param apiSecret 项目 API Secret
     * @param app       应用方业务接口
     * @return
     */
    public static String callBackV1(String body, String signature, String apiSecret, APP app) {
        JSONObject jsonObj = JSON.parseObject(body);
        String jsonStr = JSON.toJSONString(jsonObj, SerializerFeature.MapSortField);
        // 执行签名
        String hexHash = sha256Sum(jsonStr + apiSecret);
        if (hexHash.equals(signature)) {
            app.onCallbackV1(body, signature, apiSecret);
            return "SUCCESS";
        } else
            return "FAILED";
    }

    /**
     * 如果对接的是 v2 及其以上版本，用以下方式验签
     *
     * @param path      在 Avata服务平台设置的回调地址(去掉域名)
     * @param body      来自 Avata API 推送的请求体参数
     * @param timeStamp 来自 Avata API 推送的请求头中的时间戳
     * @param apiSecret 项目 API Secret
     * @param signature 来自 Avata API 推送的请求头的签名，与 网关鉴权签名 方式保持一致
     * @param app       应用方业务接口
     * @return
     */

    public static String callBack(String path, String body, Long timeStamp, String apiSecret, String signature, APP app) {
        String hexHash = sign(path, null, getMap(body), timeStamp, apiSecret);
        if (hexHash.equals(signature)) {
            app.onCallback(path, body, timeStamp, apiSecret, signature);
            return "SUCCESS";
        } else
            return "FAILED";
    }

    public static Map<String, Object> getMap(String params) {
        Map<String, Object> maps = JSON.parseObject(params);
        return maps;
    }

    /**
     * 业务接口，应用方需要实现业务逻辑，在验签成功后执行
     */
    public interface APP {

        // 如果对接的是 v1 版本，实现以下业务逻辑
        void onCallbackV1(String body, String signature, String apiSecret);

        // 如果对接的是 v2 及其以上版本，实现以下业务逻辑
        void onCallback(String path, String body, Long timeStamp, String apiSecret, String signature);
    }
}