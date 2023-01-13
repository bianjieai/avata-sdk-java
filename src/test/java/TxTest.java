import model.tx.QueryQueueResponse;
import model.tx.QueryTxResponse;
import org.junit.jupiter.api.Test;

public class TxTest {
    Client client = new Client.Builder()
            .setDoMain("http://192.168.150.41:18081")
            .setApiKey("000001")
            .setApiSecret("ceshi")
            .init();

    @Test
    public void queryTx(){
        QueryTxResponse txRes = client.txClient.queryTx("lmhcreatenft003");
        System.out.println(txRes.getData());
    }

    @Test
    public void queryQueueInfo(){
        QueryQueueResponse res = client.txClient.queryQueueInfo();

        System.out.println(res.getData());
    }
}
