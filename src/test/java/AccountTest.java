import model.account.CreateAccountReq;
import model.account.CreateAccountRes;
import model.account.QueryAccountsRes;
import model.tx.QueryQueueResponse;
import org.junit.jupiter.api.Test;

public class AccountTest {
    Client client = new Client.Builder()
            .setDoMain("http://192.168.150.41:18081")
            .setApiKey("000001")
            .setApiSecret("ceshi")
            .init();
    @Test
    void TestCreateAccount() {
        CreateAccountReq req = new CreateAccountReq();
        req.setName("dxycfuvgibo");
        req.setOperationId("operationId341833");
        try {
            CreateAccountRes account = client.accountClient.createAccount(req);
            System.out.println(account.getData());
            System.out.println("no exception");
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
