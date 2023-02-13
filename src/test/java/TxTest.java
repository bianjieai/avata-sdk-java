
import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.tx.QueryQueueReq;
import ai.bianjie.avatasdk.model.tx.QueryQueueRes;
import ai.bianjie.avatasdk.model.tx.QueryTxRes;
import org.junit.jupiter.api.Test;

public class TxTest {
    AvataClient client = new AvataClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .init();

    @Test
    // 请求上链交易结果查询接口示例
    public void queryTx() {

        QueryTxRes txRes = client.txClient.queryTx("operationID1676014869");

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
