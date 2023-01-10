import model.PublicResponse;
import model.nft.CreateNftRequest;
import org.junit.jupiter.api.Test;

public class TxTest {
    @Test
    public void queryTx(){
        Client client = new Client.Builder()
                .setDoMain("http://192.168.150.41:18081")
                .setApiKey("000001")
                .setApiSecret("ceshi")
                .init();
//        TxRes txRes = client.txClient.queryTx("0816sxjtest001ss1111s");
        CreateNftRequest req = new CreateNftRequest();
        req.setName("");
        PublicResponse res = client.nftClient.createNft(req, "classId");

        System.out.println(res.getData().getOperationId());
    }

}
