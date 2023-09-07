package ai.bianjie.avatasdk.util;

import ai.bianjie.avatasdk.exception.AvataException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import static ai.bianjie.avatasdk.util.AvataUtils.sha256Sum;
import static ai.bianjie.avatasdk.util.AvataUtils.sign;

public class CallBackUtils {

    // 验证签名时传入的 API 版本号
    public static final String APIVersionV1 = "v1"; // v1 版本 AVATA Open API
    public static final String APIVersionsOther = ""; // 其它版本 AVATA Open API,如 v2、v3


    // CallBackV1 v1 版本签名回调验签
    public static boolean callBackV1(HttpServletRequest r, String apiSecret) {
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
            // 处理异常
            e.printStackTrace();
            return false;
        }
    }

    // CallBack  v2 及其以上版本签名回调验签
    public static boolean callBack(HttpServletRequest r, String path, String apiSecret) {
        try {
            String signature = r.getHeader("X-Signature");
            Long timestamp = Long.valueOf(r.getHeader("X-Timestamp"));
            String hexHash = sign(path, null, getRequestBody(r), timestamp, apiSecret);
            if (!hexHash.equals(signature)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            // 处理其他异常
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
     * @throws IOException
     */
    public static String onCallback(String version, String apiSecret, String path, HttpServletRequest r, APP app) throws Exception {
        boolean result;
        switch (version) {
            case APIVersionV1:
                result = callBackV1(r, apiSecret);
                break;
            case APIVersionsOther:
                result = callBack(r, path, apiSecret);
                break;
            default:
                throw AvataException.NewSDKException("version verification failed"); // 版本不对，报错版本验证失败
        }
        if (!result) {
            throw AvataException.NewSDKException("signature verification failed"); // 签名验证失败
        }

        // 该笔推送消息属于文昌链上链完成所推送消息，请及时存储数据
        try {
            app.app(r, version, apiSecret, path);
        } catch (Exception e) {
            throw e;
        }
        return "SUCCESS"; // 向 Avata 服务器返回结果
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
        void app(HttpServletRequest r, String version, String apiSecret, String path) throws Exception;
    }
}



