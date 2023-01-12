import config.ConfigCache;
import constant.ErrorMessage;
import exception.SdkException;
import proxy.account.impl.AccountClient;
import model.mt.MtClient;
import proxy.nft.impl.NftClient;
import proxy.order.impl.OrderClient;
import proxy.records.impl.RecordsClient;
import proxy.tx.impl.TxClient;
import util.Strings;

public class Client {
    public NftClient nftClient;
    public AccountClient accountClient;
    public MtClient mtClient;
    public OrderClient orderClient;
    public RecordsClient recordsClient;
    public TxClient txClient;

    /**
     * SDK initialization method
     */
    private Client(Builder builder) {
        this.accountClient = new AccountClient();
        this.nftClient = new NftClient();
        this.mtClient = new MtClient();
        this.orderClient = new OrderClient();
        this.recordsClient = new RecordsClient();
        this.txClient = new TxClient();
    }

    public static class Builder {
        private String doMain;
        private String apiKey;
        private String apiSecret;
        private Integer httpTimeout;

        public Builder setDoMain(String doMain) {
            if (Strings.isEmpty(doMain)) {
                throw new SdkException(ErrorMessage.DOMAIN_ERROR, null, null);
            }
            this.doMain = doMain;
            return this;
        }

        public Builder setHttpTimeout(Integer httpTimeout) {
            if (httpTimeout == null) {
                this.httpTimeout = 10000;
                return this;
            }
            if (httpTimeout < 0) {
                throw new SdkException(ErrorMessage.HTTP_TIMEOUT_ERROR, null, null);
            }
            this.httpTimeout = httpTimeout;
            return this;
        }

        public Builder setApiKey(String apiKey) {
            if (Strings.isEmpty(apiKey)) {
                throw new SdkException(ErrorMessage.API_KEY_ERROR, null, null);
            }
            this.apiKey = apiKey;
            return this;
        }

        public Builder setApiSecret(String apiSecret) {
            if (Strings.isEmpty(apiSecret)) {
                throw new SdkException(ErrorMessage.API_SECRET_ERROR, null, null);
            }
            this.apiSecret = apiSecret;
            return this;
        }

        public Client init() {
            ConfigCache.initCache(doMain, httpTimeout, apiKey, apiSecret);
            return new Client(this);
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
