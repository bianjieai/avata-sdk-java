import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.tx.QueryTxRes;
import org.junit.jupiter.api.Test;

public class TxTest {
    AvataClient client = new AvataClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();

    @Test
    // 请求上链交易结果查询接口示例
    public void queryTx() {
        QueryTxRes txRes = client.txClient.queryTx("");
        System.out.println(txRes.getData());
    }
}
