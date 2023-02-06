package util;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.Forest;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;

import java.util.Map;

import config.ConfigCache;
import constant.ErrorMessage;
import exception.SdkException;
import model.ErrorResponse;
import model.account.CreateAccountRes;

public class HttpClient {
    /**
     * Send a post request
     */
    public static ForestResponse Post(String path, String content) {
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
        ForestResponse response = req.execute(ForestResponse.class);
        validateResponse(response);
        return response;
    }

    /**
     * Send a get request
     */
    public static ForestResponse Get(String path, String content) {
        StringBuffer url = new StringBuffer();
        url.append(ConfigCache.get().getDoMain());
        url.append(path);
        ForestRequest<?> req = Forest.get(url.toString());

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
        ForestResponse response = req.execute(ForestResponse.class);
        validateResponse(response);
        return response;
    }

    /**
     * Send a patch request
     */
    public static ForestResponse Patch(String path, String content) {
        StringBuffer url = new StringBuffer();
        url.append(ConfigCache.get().getDoMain());
        url.append(path);
        ForestRequest<?> req = Forest.patch(url.toString()).contentTypeJson();

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
        ForestResponse response = req.execute(ForestResponse.class);
        validateResponse(response);
        return response;
    }

    /**
     * Send a delete request
     */
    public static ForestResponse Delete(String path, String content) {
        StringBuffer url = new StringBuffer();
        url.append(ConfigCache.get().getDoMain());
        url.append(path);
        ForestRequest<?> req = Forest.delete(url.toString()).contentTypeJson();

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
        ForestResponse response = req.execute(ForestResponse.class);
        validateResponse(response);
        return response;
    }

    /**
     * Validate ForestResponse
     */
    public static void validateResponse(ForestResponse response) {
        // timeout error
        if (response.isTimeout()) {
            throw new SdkException(ErrorMessage.REQUEST_TIMEOUT_ERROR, null, null);
        }
        // Determine whether the network request failed
        if (response.isError()) {
            // Get the exception generated during the request
            if (response.getException() != null) {
                throw new SdkException(-1, response.getException().getMessage(), null, null);
            }
            ErrorResponse res = JSONObject.parseObject(response.getContent(), ErrorResponse.class);
            throw new SdkException(ErrorMessage.UNKNOWN_ERROR, res.getError(), null);
        }
    }
}
