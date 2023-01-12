package util;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.Forest;
import com.dtflys.forest.http.ForestRequest;
import config.ConfigCache;
import okhttp3.*;
import sun.security.util.Length;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class HttpClient {
    /**
     * Send a post request
     */
    public static ForestRequest<?> Post(String path, String content) {
        StringBuffer url = new StringBuffer();
        url.append(ConfigCache.get().getDoMain());
        url.append(path);
        ForestRequest<?> req = Forest.post(url.toString()).contentTypeJson();

        // signature
        Long currentTime = System.currentTimeMillis();
        Map<String, Object> body = JSONObject.parseObject(content);
        String signature = AvataUtils.signature(path, null, body, currentTime, ConfigCache.get().getApiSecret());
        req.addHeader("x-api-key", ConfigCache.get().getApiKey());
        req.addHeader("x-timestamp", String.valueOf(currentTime));
        req.addHeader("x-signature", signature);
        if (body != null) {
            req.addBody(body);
        }
        return req;
    }

    /**
     * Send a get request
     */
    public static ForestRequest<?> Get(String path, String content) {
        StringBuffer url = new StringBuffer();
        url.append(ConfigCache.get().getDoMain());
        url.append(path);
        ForestRequest<?> req = Forest.get(url.toString()).contentTypeJson();

        // signature
        Long currentTime = System.currentTimeMillis();
        Map<String, Object> query = JSONObject.parseObject(content);
        String signature = AvataUtils.signature(path, query, null, currentTime, ConfigCache.get().getApiSecret());
        req.addHeader("x-api-key", ConfigCache.get().getApiKey());
        req.addHeader("x-timestamp", String.valueOf(currentTime));
        req.addHeader("x-signature", signature);
        if (query != null) {
            req.addQuery(query);
        }
        return req;
    }
}
