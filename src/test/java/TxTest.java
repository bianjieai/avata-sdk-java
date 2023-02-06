
import model.tx.QueryQueueResponse;
import model.tx.QueryTxResponse;
import org.junit.jupiter.api.Test;

public class TxTest {
    Client client = new Client.Builder()
            .setDoMain("https://192.168.150.41:18081")
            .setApiKey("000001")
            .setApiSecret("ceshi")
            .setHttpTimeout(10000)
            .init();

    @Test
    // 请求上链交易结果查询接口示例
    public void queryTx() {

        QueryTxResponse txRes = client.txClient.queryTx("1675319615348");

        System.out.println(txRes.getData());
    }

    @Test
    //请求上链交易排队状态查询接口示例
    public void queryQueueInfo() {
        QueryQueueResponse res = client.txClient.queryQueueInfo();

        System.out.println(res.getData());
    }
}
