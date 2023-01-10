package config;

public class ConfigInfo {

    private String doMain = "localhost:8096";

    private String apiKey;

    private String apiSecret;

    private long connectTimeout;

    public ConfigInfo() {
        /**
         * default 10s
         */
        connectTimeout = 10;
    }

    public String getDoMain() {
        return doMain;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public void setDoMain(String doMain) {
        this.doMain = doMain;
    }

    public long getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
    }
}
