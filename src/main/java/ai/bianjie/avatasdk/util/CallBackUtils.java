package ai.bianjie.avatasdk.util;

import ai.bianjie.avatasdk.exception.AvataException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Map;

import static ai.bianjie.avatasdk.util.AvataUtils.sha256Sum;
import static ai.bianjie.avatasdk.util.AvataUtils.sign;

public class CallBackUtils {

    // 验证签名时传入的 API 版本号
    public static final String APIVersionV1 = "v1"; // v1 版本 AVATA Open API
    public static final String APIVersionsOther = "v3"; // 其它版本 AVATA Open API,如 v2、v3


    /**
     * CallBackV1 v1 版本签名回调验签
     *
     * @param body      来自 Avata API 推送的请求体参数
     * @param signature 来自 Avata API 推送的请求头的签名，算法为 SHA256 (body + ApiSecret)
     * @param apiSecret 项目 API Secret
     * @return
     */
    public static boolean callBackV1(String body, String signature, String apiSecret) {
        JSONObject jsonObj = JSON.parseObject(body);
        String jsonStr = JSON.toJSONString(jsonObj, SerializerFeature.MapSortField);
        // 执行签名
        String hexHash = sha256Sum(jsonStr + apiSecret);
        if (!hexHash.equals(signature)) {
            return false;
        }
        return true;
    }

    /**
     * CallBack  v2 及其以上版本签名回调验签
     *
     * @param path      在 Avata服务平台设置的回调地址(去掉域名)
     * @param body      来自 Avata API 推送的请求体参数
     * @param timeStamp 来自 Avata API 推送的请求头中的时间戳
     * @param apiSecret 项目 API Secret
     * @param signature 来自 Avata API 推送的请求头的签名，与 网关鉴权签名 方式保持一致
     * @return
     */
    public static boolean callBack(String path, String body, Long timeStamp, String apiSecret, String signature) {
        String hexHash = sign(path, null, getMap(body), timeStamp, apiSecret);
        if (!hexHash.equals(signature)) {
            return false;
        }
        return true;
    }

    public static Map<String, Object> getMap(String params) {
        Map<String, Object> maps = JSON.parseObject(params);
        return maps;
    }

    /**
     * 接收来自 Avata 的推送消息
     *
     * @param version   版本 ：v1 需要传 APIVersionV1 , v2 或者 v3 版本传 APIVersionsOther
     * @param body      来自 Avata API 推送的请求体参数
     * @param timeStamp 来自 Avata API 推送的请求头中的时间戳
     * @param apiSecret 项目 API Secret
     * @param signature 来自 Avata API 推送的请求头的签名，与 网关鉴权签名 方式保持一致
     * @param path      在 Avata服务平台设置的回调地址(去掉域名)
     * @param app       自己的业务逻辑代码（验证签名通过才会执行）
     * @return
     */
    public static String onCallback(String version, String body, Long timeStamp, String apiSecret, String signature, String path, APP app) {
        boolean result = true;
        switch (version) {
            case APIVersionV1:
                result = callBackV1(body, signature, apiSecret);
                app.appV1(body, signature, apiSecret);   // 该笔推送消息属于文昌链上链完成所推送消息，请及时存储数据
                break;
            case APIVersionsOther:
                result = callBack(path, body, timeStamp, apiSecret, signature);
                app.app(path, body, timeStamp, apiSecret, signature);   // 该笔推送消息属于文昌链上链完成所推送消息，请及时存储数据
                break;
            default:
                throw AvataException.NewSDKException("version verification failed");
        }
        if (!result) {
            throw AvataException.NewSDKException("signature verification failed");
        }

        // 返回给消息推送端
        return "SUCCESS";
    }


    /**
     * 业务接口，应用方需要实现业务逻辑，在验签成功后执行
     */
    public interface APP {

        // 如果对接的是 v1 版本，实现以下业务逻辑
        void appV1(String body, String signature, String apiSecret);

        // 如果对接的是 v2 及其以上版本，实现以下业务逻辑
        void app(String path, String body, Long timeStamp, String apiSecret, String signature);
    }
}


