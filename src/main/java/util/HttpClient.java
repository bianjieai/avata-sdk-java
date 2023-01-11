package util;

import config.ConfigCache;
import okhttp3.*;

import java.io.IOException;
import java.time.Duration;

public class HttpClient {
    private static OkHttpClient okHttpClient;

    static {
        okHttpClient = new OkHttpClient().newBuilder()
                .callTimeout(Duration.ofSeconds(ConfigCache.get().getHttpTimeout()))
                .build();
    }

    /**
     * Send a post request
     */
    public static Response Post(String path, String content) throws Exception {
        StringBuffer url = new StringBuffer();
        url.append(ConfigCache.get().getDoMain());
        url.append(path);

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, content);
        Request request = new Request.Builder()
                .url(url.toString())
                .method("POST", body)
                .addHeader("x-api-key", ConfigCache.get().getApiKey())
                .addHeader("Content-Type", "application/json")
                .build();
        request = AvataUtils.signReq(request);
        return okHttpClient.newCall(request).execute();
    }

    /**
     * Send a get request
     */
    public static Response Get(String path, String content) throws Exception {
        StringBuffer url = new StringBuffer();
        url.append(ConfigCache.get().getDoMain());
        url.append(path);
        url.append(content);
        Request request = new Request.Builder()
                .url(url.toString())
                .method("GET", null)
                .addHeader("x-api-key", ConfigCache.get().getApiKey())
                .build();
        request = AvataUtils.signReq(request);
        return okHttpClient.newCall(request).execute();
    }
}
