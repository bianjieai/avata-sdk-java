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
     * @param business  应用方业务接口
     * @return
     */
    public static String callBackV1(String body, String signature, String apiSecret, business business) {
        JSONObject jsonStr = JSON.parseObject(body);
        String jsonStr1 = JSON.toJSONString(jsonStr, SerializerFeature.MapSortField);
        // 执行签名
        String signature1 = sha256Sum(jsonStr1 + apiSecret);
        if (signature1.equals(signature)) {
            //将body存储到本地
            business.businessFunction();
            return "SUCCESS";
        } else
            return "FAILED";
    }

    /**
     * 如果对接的是 v2 以其以上版本版本，用以下方式验签
     *
     * @param path      在 Avata服务平台设置的回调地址(去掉域名)
     * @param body      来自 Avata API 推送的请求体参数
     * @param timeStamp 来自 Avata API 推送的请求头中的时间戳
     * @param apiSecret 项目 API Secret
     * @param signature 来自 Avata API 推送的请求头的签名，与 网关鉴权签名 方式保持一致
     * @param business  应用方业务接口
     * @return
     */

    public static String callBack(String path, String body, Long timeStamp, String apiSecret, String signature, business business) {
        String signature2 = sign(path, null, getMap(body), timeStamp, apiSecret);
        if (signature2.equals(signature)) {
            //将body存储到本地
            business.businessFunction();
            return "SUCCESS";
        } else
            return "FAILED";
    }

    public static Map<String, Object> getMap(String canshu) {
        Map<String, Object> maps = JSON.parseObject(canshu);
        return maps;
    }

    /**
     * 业务接口，应用方需要实现业务逻辑，在验签成功后执行
     * 此处定义一个接口，用于应用方实现，因为是重写改方法，所以无需添加参数（不涉及到调用传参的逻辑）
     */
    public interface business {
        void businessFunction();
    }
}