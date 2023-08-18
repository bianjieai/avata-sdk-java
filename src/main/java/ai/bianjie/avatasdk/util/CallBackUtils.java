package ai.bianjie.avatasdk.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Map;

import static ai.bianjie.avatasdk.util.AvataUtils.sha256Sum;
import static ai.bianjie.avatasdk.util.AvataUtils.sign;

public class CallBackUtils {

    // 如果对接的是 v1 版本，用以下方式验签
    public static String callBackV1(String body, String signature,String apiSecret,business func) {
        JSONObject jsonStr = JSON.parseObject(body);
        String jsonStr1 = JSON.toJSONString(jsonStr, SerializerFeature.MapSortField);
        // 执行签名
        String signature1 = sha256Sum(jsonStr1 + apiSecret);
        if (signature1.equals(signature)) {
            //将body存储到本地
            func.businessFunction();
            return "SUCCESS";
        } else
            return "FAILED";
    }

    // 如果对接的是 v2 以其以上版本版本，用以下方式验签
    public static String callBack(String path, String body,Long timeStamp,String apiSecret,String signature,business func) {
        String signature2 = sign(path, null, getMap(body), timeStamp, apiSecret);
        if (signature2.equals(signature)) {
            //将body存储到本地
            func.businessFunction();
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
     */
    public  interface business{
        void businessFunction();
    }
}

