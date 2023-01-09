import config.ConfigCache;
import constant.ErrorMessage;
import exception.SdkException;
import model.account.AccountClient;
import model.mt.MtClient;
import model.nft.NftClient;
import model.order.OrderClient;
import model.records.RecordsClient;
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
        private String avataGateway;
        private String apiKey;
        private String apiSecret;

        public Builder setAvataGateway(String avataGateway) {
            if (Strings.isEmpty(avataGateway)) {
                throw new SdkException(ErrorMessage.UNKNOWN_ERROR);
            }
            this.avataGateway = avataGateway;
            return this;
        }

        public Builder setApiKey(String apiKey) {
            if (Strings.isEmpty(apiKey)) {
                throw new SdkException(ErrorMessage.UNKNOWN_ERROR);
            }
            this.apiKey = apiKey;
            return this;
        }

        public Builder setApiSecret(String apiSecret) {
            if (Strings.isEmpty(apiSecret)) {
                throw new SdkException(ErrorMessage.UNKNOWN_ERROR);
            }
            this.apiSecret = apiSecret;
            return this;
        }

        public Client init() {
            ConfigCache.initCache(avataGateway, apiKey, apiSecret);
            return new Client(this);
        }
    }

    public Boolean setGatewayUrl(String gatewayUrl) {
        if (gatewayUrl.isEmpty()) {
            return false;
        }
        ConfigCache.get().setAvataGatewayAddress(gatewayUrl);
        return true;
    }
}
