package util;

import config.ConfigCache;
import okhttp3.*;

import java.io.IOException;

public class HttpReq {
    private static OkHttpClient okHttpClient;

    static {
        okHttpClient = new OkHttpClient().newBuilder()
                .build();
    }

    /**
     * todo
     */
    public Response Post(String content) {

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, content);
        Request request = new Request.Builder()
                .url(ConfigCache.get().getAvataGatewayAddress())
                .method("POST", body)
                .addHeader("x-api-key", ConfigCache.get().getApiKey())
                .addHeader("Content-Type", "application/json")
                .build();
        request = AvataUtils.signReq(request);
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
        }catch (IOException e) {
            // todo 异常处理
        }

        return response;
    }

    /**
     * todo
     */
    public Response Get(String content) {
        String url = ConfigCache.get().getAvataGatewayAddress() + content;
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .addHeader("x-api-key", ConfigCache.get().getApiKey())
                .build();
        request = AvataUtils.signReq(request);
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            // todo 异常处理
        }
        return response;
    }
}
