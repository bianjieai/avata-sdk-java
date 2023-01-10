package config;

import util.Strings;

import java.util.concurrent.ConcurrentHashMap;

public class ConfigCache {
    private ConfigCache() {
    }

    private static final String SDK_CACHE_KEY = "sdk_config";

    private static final ConcurrentHashMap<String, ConfigInfo> MAP = new ConcurrentHashMap<>();

    public static void initCache(String avataGateway, String apiKey, String apiSecret) {
        ConfigInfo configInfo = new ConfigInfo();

        if (!Strings.isEmpty(avataGateway)) {
            configInfo.setDoMain(avataGateway);
        }
        if (!Strings.isEmpty(apiKey)) {
            configInfo.setApiKey(apiKey);
        }
        if (!Strings.isEmpty(apiSecret)) {
            configInfo.setApiSecret(apiSecret);
        }

        MAP.put(SDK_CACHE_KEY, configInfo);

    }

    public static final ConfigInfo get() {
        return MAP.get(SDK_CACHE_KEY);
    }

}
