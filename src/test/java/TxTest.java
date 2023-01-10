import model.PublicResponse;
import model.nft.CreateNftRequest;
import model.tx.QueryTxResponse;
import org.junit.jupiter.api.Test;

public class TxTest {
    @Test
    public void queryTx(){
        Client client = new Client.Builder()
                .setDoMain("http://192.168.150.41:18081")
                .setApiKey("000001")
                .setApiSecret("ceshi")
                .init();
        QueryTxResponse txRes = client.txClient.queryTx("0816sxjtest001ss1111s");

        System.out.println(txRes.getCode());
    }

}
