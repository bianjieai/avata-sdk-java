package ai.bianjie.avatasdk.config;

import lombok.Data;

/**
 * 配置项
 */
@Data
public class ConfigInfo {

    private String doMain; // 域名

    private String apiKey; // 项目参数 API KEY

    private String apiSecret; // 项目参数 API SECRET
    private Integer httpTimeout; // 响应超时时间

    public ConfigInfo() {
        /**
         * default 10000ms
         */
        httpTimeout = 10000;
    }
}
