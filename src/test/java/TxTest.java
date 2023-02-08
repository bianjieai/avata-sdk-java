
import model.tx.QueryQueueReq;
import model.tx.QueryQueueRes;
import model.tx.QueryTxRes;
import org.junit.jupiter.api.Test;

public class TxTest {
    AvataClient client = new AvataClient.Builder()
            .setDomain("http://192.168.150.41:18081")
            .setApiKey("000001")
            .setApiSecret("test")
            .setHttpTimeout(10000)
            .init();

    @Test
    // 请求上链交易结果查询接口示例
    public void queryTx() {

        QueryTxRes txRes = client.txClient.queryTx("1675319615348");

        System.out.println(txRes.getData());
    }

    @Test
    //请求上链交易排队状态查询接口示例
    public void queryQueueInfo() {
        QueryQueueReq req = new QueryQueueReq();
        req.setOperationId("test");
        QueryQueueRes res = client.txClient.queryQueueInfo(req);

        System.out.println(res.getData());
    }
}
