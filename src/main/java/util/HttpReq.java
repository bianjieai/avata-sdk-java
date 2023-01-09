package util;

import config.ConfigCache;
import okhttp3.*;

public class HttpReq {
    private static OkHttpClient okHttpClient;

    static {
        okHttpClient = new OkHttpClient().newBuilder()
                .build();
    }

    /**
     * todo
     */
    public ResponseBody Post(String content) {

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, content);
        Request request = new Request.Builder()
                .url(ConfigCache.get().getAvataGatewayAddress())
                .method("POST", body)
                .addHeader("x-api-key", ConfigCache.get().getApiKey())
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
        }catch (Exception e) {
            // todo 异常处理
        }

        return response.body();
    }

    /**
     * todo
     */
    public void Get() {

    }
}
