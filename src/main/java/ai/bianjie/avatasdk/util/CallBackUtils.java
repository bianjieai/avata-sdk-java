package ai.bianjie.avatasdk.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Map;

import static ai.bianjie.avatasdk.util.AvataUtils.sha256Sum;
import static ai.bianjie.avatasdk.util.AvataUtils.sign;

public class CallBackUtils {

    // 如果对接的是 v1 版本，用以下方式验签
    public static String callBackV1(String body, String signature) {
        JSONObject jsonStr = JSON.parseObject(body);
        String jsonStr1 = JSON.toJSONString(jsonStr, SerializerFeature.MapSortField);
        // 执行签名
        String signature1 = sha256Sum(jsonStr1 + "api_secret");
        if (signature1 == signature) {
            //将body存储到本地
            //TODO
            return "SUCCESS";
        } else
            return "FAILED";
    }


    // 如果对接的是 v2 或者 v3 版本，用以下方式验签
    public static String callBack(String path, String body,Long timeStamp,String apiSecret,String signature) {
        String signature2 = sign(path, null, getMap(body), timeStamp, apiSecret);
        if (signature2 == signature) {
            //将body存储到本地
            //TODO
            return "SUCCESS";
        } else
            return "FAILED";
    }

    public static Map<String, Object> getMap(String canshu) {
        Map<String, Object> maps = JSON.parseObject(canshu);
        return maps;
    }
}