package ai.bianjie.avatasdk;

import ai.bianjie.avatasdk.config.ConfigInfo;
import ai.bianjie.avatasdk.exception.AvataException;
import ai.bianjie.avatasdk.proxy.nat.mt.impl.MtClient;
import ai.bianjie.avatasdk.proxy.nat.nft.impl.NftClient;
import ai.bianjie.avatasdk.proxy.nat.records.impl.RecordsClient;
import ai.bianjie.avatasdk.proxy.nat.tx.impl.TxClient;
import com.dtflys.forest.Forest;
import com.dtflys.forest.config.ForestConfiguration;
import com.dtflys.forest.http.ForestAsyncMode;
import com.dtflys.forest.retryer.BackOffRetryer;
import com.dtflys.forest.ssl.SSLUtils;
import com.dtflys.forest.utils.StringUtils;

public class AvataNativeClient {

    public NftClient nftClient;
    public MtClient mtClient;
    public RecordsClient recordsClient;
    public TxClient txClient;


    /**
     * SDK initialization method
     */
    private AvataNativeClient(Builder builder) {
        ConfigInfo configInfo = new ConfigInfo();
        configInfo.setDoMain(builder.domain);
        configInfo.setApiKey(builder.apiKey);
        configInfo.setApiSecret(builder.apiSecret);
        configInfo.setHttpTimeout(builder.httpTimeout);

        this.nftClient = new NftClient(configInfo);
        this.mtClient = new MtClient(configInfo);
        this.recordsClient = new RecordsClient(configInfo);
        this.txClient = new TxClient(configInfo);
    }

    public static class Builder {
        private String domain;
        private String apiKey;
        private String apiSecret;
        private Integer httpTimeout;
        private Boolean log;

        public Builder setDomain(String domain) {
            this.domain = domain;
            return this;
        }

        public Builder setHttpTimeout(Integer httpTimeout) {
            this.httpTimeout = httpTimeout;
            return this;
        }

        public Builder setApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder setApiSecret(String apiSecret) {
            this.apiSecret = apiSecret;
            return this;
        }

        public Builder setLog(Boolean log) {
            this.log = log;
            return this;
        }

        public AvataNativeClient init() {
            if (StringUtils.isEmpty(domain)) {
                throw AvataException.NewSDKException(AvataException.ErrDomain);
            }
            if (StringUtils.isEmpty(apiKey)) {
                throw AvataException.NewSDKException(AvataException.ErrAPIKey);
            }
            if (StringUtils.isEmpty(apiSecret)) {
                throw AvataException.NewSDKException(AvataException.ErrAPISecret);
            }
            if (httpTimeout == null) {
                httpTimeout = 10000;
            }
            if (httpTimeout < 0) {
                throw AvataException.NewSDKException(AvataException.HTTP_TIMEOUT_ERROR);
            }

            if (log == null) {
                log = true;
            }

            // init forest
            ForestConfiguration configuration = Forest.config();
            configuration.setBackendName("okhttp3");
            // 连接池最大连接数，默认值为500
            configuration.setMaxConnections(100);
            // 每个路由的最大连接数，默认值为500
            configuration.setMaxRouteConnections(200);
            // [自v1.5.22版本起可用] 最大请求等待队列大小
            configuration.setMaxRequestQueueSize(100);
            // [自v1.5.21版本起可用] 最大异步线程数
            configuration.setMaxAsyncThreadSize(300);
            // [自v1.5.22版本起可用] 最大异步线程池队列大小
            configuration.setMaxAsyncQueueSize(16);
            // 请求超时时间，单位为毫秒, 默认值为3000
            configuration.setTimeout(httpTimeout);
            // 连接超时时间，单位为毫秒, 默认值为2000
            configuration.setConnectTimeout(2000);
            // 设置重试器
            configuration.setRetryer(BackOffRetryer.class);
            // 请求失败后重试次数，默认为0次不重试, 无用配置
            configuration.setMaxRetryCount(0);
            // 单向验证的HTTPS的默认SSL协议，avata 需要TLS_1_2
            configuration.setSslProtocol(SSLUtils.TLS_1_2);
            // 打开或关闭日志，默认为true
            configuration.setLogEnabled(log);
            // [自v1.5.27版本起可用] 异步模式（默认为 platform）
            configuration.setAsyncMode(ForestAsyncMode.PLATFORM);

            return new AvataNativeClient(this);
        }
    }
}