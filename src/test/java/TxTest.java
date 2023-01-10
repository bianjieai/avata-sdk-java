import model.PublicResponse;
import model.nft.CreateNftRequest;
import model.tx.TxRes;
import org.junit.jupiter.api.Test;

public class TxTest {
    @Test
    public void queryTx() {
        Client client = new Client.Builder()
                .setAvataGateway("http://192.168.150.41:18081")
                .setApiKey("000001")
                .setApiSecret("ceshi")
                .init();
        TxRes txRes = client.txClient.queryTx("0816sxjtest001ss1111s");

    }

}
