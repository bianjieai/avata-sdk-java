package ai.bianjie.avatasdk.config;

/**
 * 配置项
 *
 * @author sxj
 */
public class ConfigInfo {

    private String doMain;

    private String apiKey;

    private String apiSecret;

    private Integer httpTimeout;

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

    public Integer getHttpTimeout() {
        return httpTimeout;
    }

    public void setHttpTimeout(Integer httpTimeout) {
        this.httpTimeout = httpTimeout;
    }
}
