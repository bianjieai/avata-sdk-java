package config;

public class ConfigInfo {

    private String doMain = "localhost:8096";

    private String apiKey;

    private String apiSecret;

    private long httpTimeout;

    public ConfigInfo() {
        /**
         * default 10000ms
         */
        httpTimeout = 10000;
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

    public long getHttpTimeout() {
        return httpTimeout;
    }

    public void setHttpTimeout(long httpTimeout) {
        this.httpTimeout = httpTimeout;
    }
}
