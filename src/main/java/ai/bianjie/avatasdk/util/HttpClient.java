package ai.bianjie.avatasdk.util;

import ai.bianjie.avatasdk.config.ConfigInfo;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.Forest;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;

import java.util.Map;

import ai.bianjie.avatasdk.exception.AvataException;
import lombok.extern.slf4j.Slf4j;
import ai.bianjie.avatasdk.model.ErrorResponse;

@Slf4j
public class HttpClient {
    /**
     * Send a post request
     * @param path The url of the post request
     * @param content The body parameter of the post request
     */
    public static ForestResponse Post(String path, String content, ConfigInfo configInfo) {
        StringBuffer url = new StringBuffer();
        url.append(configInfo.getDoMain());
        url.append(path);
        ForestRequest<?> req = Forest.post(url.toString()).contentTypeJson();

        // signature
        Long currentTime = System.currentTimeMillis();
        Map<String, Object> body = JSONObject.parseObject(content);
        String signature = AvataUtils.sign(path, null, body, currentTime, configInfo.getApiSecret());
        req.addHeader("x-api-key", configInfo.getApiKey());
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
     * @param path The url of the get request
     * @param content The query parameter of the get request
     */
    public static ForestResponse Get(String path, String content, ConfigInfo configInfo) {
        StringBuffer url = new StringBuffer();
        url.append(configInfo.getDoMain());
        url.append(path);
        ForestRequest<?> req = Forest.get(url.toString());

        // signature
        Long currentTime = System.currentTimeMillis();
        Map<String, Object> query = JSONObject.parseObject(content);
        String signature = AvataUtils.sign(path, query, null, currentTime, configInfo.getApiSecret());
        req.addHeader("x-api-key", configInfo.getApiKey());
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
     * @param path The url of the patch request
     * @param content The body parameter of the patch request
     */
    public static ForestResponse Patch(String path, String content, ConfigInfo configInfo) {
        StringBuffer url = new StringBuffer();
        url.append(configInfo.getDoMain());
        url.append(path);
        ForestRequest<?> req = Forest.patch(url.toString()).contentTypeJson();

        // signature
        Long currentTime = System.currentTimeMillis();
        Map<String, Object> body = JSONObject.parseObject(content);
        String signature = AvataUtils.sign(path, null, body, currentTime, configInfo.getApiSecret());
        req.addHeader("x-api-key", configInfo.getApiKey());
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
     * @param path The url of the delete request
     * @param content The body parameter of the delete request
     */
    public static ForestResponse Delete(String path, String content, ConfigInfo configInfo) {
        StringBuffer url = new StringBuffer();
        url.append(configInfo.getDoMain());
        url.append(path);
        ForestRequest<?> req = Forest.delete(url.toString()).contentTypeJson();

        // signature
        Long currentTime = System.currentTimeMillis();
        Map<String, Object> body = JSONObject.parseObject(content);
        String signature = AvataUtils.sign(path, null, body, currentTime, configInfo.getApiSecret());
        req.addHeader("x-api-key", configInfo.getApiKey());
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
            log.error("http request timeout");
            throw AvataException.TimeOutException();
        }
        // Determine whether the network request failed
        if (response.isError()) {
            log.error("http request error");
            // Get the ai.bianjie.avatasdk.exception generated during the request
            if (response.getException() != null) {
                throw AvataException.NewSDKException(response.getException().getMessage());
            }
            ErrorResponse res = JSONObject.parseObject(response.getContent(), ErrorResponse.class);
            throw AvataException.NewHTTPException(res.getError());
        }
    }
}
