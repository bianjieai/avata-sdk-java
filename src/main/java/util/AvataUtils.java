package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import okhttp3.Request;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class AvataUtils {
    public static Request signReq(Request req) {
        //todo 对请求添加时间戳和签名参数
        return req;
    }

    /**
     * 对请求参数进行签名处理
     *
     * @param path      请求路径，仅截取域名后及 Query 参数前部分，例："/v1beta1/accounts";
     * @param query     Query 参数，例："key1=value1&key2=value2"，需转为 Map 格式
     * @param body      Body 参数，例："{\"count\": 1, \"operation_id\": \"random_string\"}"，需转为 Map 格式
     * @param timestamp 当前时间戳（毫秒），例：1647751123703
     * @param apiSecret 应用方的 API Secret，例："AKIDz8krbsJ5yKBZQpn74WFkmLPc5ab"
     * @return 返回签名结果
     */
    public static String signature(String path, Map<String, Object> query, Map<String, Object> body, long timestamp, String apiSecret) {
        Map<String, Object> paramsMap = new HashMap();

        paramsMap.put("path_url", path);

        if (query != null && !query.isEmpty()) {
            query.forEach((key, value) -> paramsMap.put("query_" + key, String.valueOf(value)));
        }

        if (body != null && !body.isEmpty()) {
            body.forEach((key, value) -> paramsMap.put("body_" + key, value));
        }

        // 重要提示：下载相应的依赖，请使用上方Java代码前的版本号

        // 将请求参数序列化为排序后的 JSON 字符串
        String jsonStr = JSON.toJSONString(paramsMap, SerializerFeature.MapSortField);

        // 执行签名
        String signature = sha256Sum(jsonStr + String.valueOf(timestamp) + apiSecret);

        return signature;
    }

    /**
     * SHA256 摘要
     *
     * @param str
     * @return
     */
    private static String sha256Sum(String str) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            // Should not happen
            e.printStackTrace();
        }
        byte[] encodedHash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedHash);
    }

    /**
     * 将 bytes 转为 Hex
     *
     * @param hash
     * @return
     */
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}