package ai.bianjie.avatasdk.config;

import lombok.Data;

/**
 * 配置项
 *
 * @author sxj
 */
@Data
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
}
