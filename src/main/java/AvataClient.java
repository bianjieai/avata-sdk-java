import config.ConfigCache;
import constant.ErrorMessage;
import exception.AvataException;
import proxy.account.impl.AccountClient;
import proxy.mt.impl.MtClient;
import proxy.nft.impl.NftClient;
import proxy.order.impl.OrderClient;
import proxy.record.impl.RecordClient;
import proxy.tx.impl.TxClient;
import com.dtflys.forest.utils.StringUtils;

public class AvataClient {
    public NftClient nftClient;
    public AccountClient accountClient;
    public MtClient mtClient;
    public OrderClient orderClient;
    public RecordClient recordsClient;
    public TxClient txClient;

    /**
     * SDK initialization method
     */
    private AvataClient(Builder builder) {
        this.accountClient = new AccountClient();
        this.nftClient = new NftClient();
        this.mtClient = new MtClient();
        this.orderClient = new OrderClient();
        this.recordsClient = new RecordClient();
        this.txClient = new TxClient();
    }

    public static class Builder {
        private String domain;
        private String apiKey;
        private String apiSecret;
        private Integer httpTimeout;
        private Boolean log; // todo

        public Builder setDomain(String domain) {
            if (StringUtils.isEmpty(domain)) {
                throw new AvataException(ErrorMessage.DOMAIN_ERROR, null, null);
            }
            this.domain = domain;
            return this;
        }

        public Builder setHttpTimeout(Integer httpTimeout) {
            if (httpTimeout == null) {
                this.httpTimeout = 10000;
                return this;
            }
            if (httpTimeout < 0) {
                throw new AvataException(ErrorMessage.HTTP_TIMEOUT_ERROR, null, null);
            }
            this.httpTimeout = httpTimeout;
            return this;
        }

        public Builder setApiKey(String apiKey) {
            if (StringUtils.isEmpty(apiKey)) {
                throw new AvataException(ErrorMessage.API_KEY_ERROR, null, null);
            }
            this.apiKey = apiKey;
            return this;
        }

        public Builder setApiSecret(String apiSecret) {
            if (StringUtils.isEmpty(apiSecret)) {
                throw new AvataException(ErrorMessage.API_SECRET_ERROR, null, null);
            }
            this.apiSecret = apiSecret;
            return this;
        }

        public Builder setLog(Boolean log) {
            if (log == null) {
                this.log = true;
                return this;
            }
            this.log = log;
            return this;
        }

        public AvataClient init() {
            ConfigCache.initCache(domain, httpTimeout, apiKey, apiSecret, log);
            return new AvataClient(this);
        }
    }

    public Boolean setDoMain(String doMain) {
        if (doMain.isEmpty()) {
            return false;
        }
        ConfigCache.get().setDoMain(doMain);
        return true;
    }
}
