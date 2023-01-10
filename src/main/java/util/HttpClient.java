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
    public Response Post(String path, String content) throws IOException {
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
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
        }catch (IOException e) {
            throw e;
        }

        return response;
    }

    /**
     * Send a get request
     */
    public Response Get(String path, String content) throws IOException {
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
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            throw e;
        }
        return response;
    }
}
