
import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.tx.QueryQueueReq;
import ai.bianjie.avatasdk.model.tx.QueryQueueRes;
import ai.bianjie.avatasdk.model.tx.QueryTxRes;
import org.junit.jupiter.api.Test;

public class TxTest {
    AvataClient client = new AvataClient.Builder()
            .setDomain("https://stage.apis.avata.bianjie.ai")
            .setApiKey("N282j1X1E1K6h0k1U3b4A3a9G4B7g86Q")
            .setApiSecret("M2t2B1m1H1U6E0u1g3a4Y3f9p4k7y92G")
            .setHttpTimeout(10000)
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
