import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.tx.QueryTxRes;
import org.junit.jupiter.api.Test;

public class TxTest {
    private final static String URL = "";
    private final static String API_KEY = "";
    private final static String API_SECRET = "";


    AvataClient client = new AvataClient.Builder()
            .setDomain(URL)
            .setApiKey(API_KEY)
            .setApiSecret(API_SECRET)
            .setHttpTimeout(10000)
            .init();

    @Test
    // 请求上链交易结果查询接口示例
    public void queryTx() {

        QueryTxRes txRes = client.txClient.queryTx("16eb42d9-3ac1-4f23-a03c-6da38feefb72");

        System.out.println(txRes.getData());
    }

}
