import model.account.CreateAccountReq;
import model.account.CreateAccountRes;
import model.account.QueryAccountsReq;
import model.account.QueryAccountsRes;
import org.junit.jupiter.api.Test;

public class AccountTest {
    Client client = new Client.Builder()
//            .setDoMain("https://stage.apis.avata.bianjie.ai")
//            .setApiKey("L2z2v0R821M7j0F2o5W905r0T904y73z")
//            .setApiSecret("Y2o250S8N1P7D0t2y5T9z5f0p9E407me")
            .setDoMain("http://192.168.150.41:18081")
            .setApiKey("000001")
            .setApiSecret("ceshi")
            .init();
    @Test
    void TestCreateAccount() {
        CreateAccountReq req = new CreateAccountReq();
        req.setName("lmhaccount");
        req.setOperationId("lmhaccount000002");
        try {
            CreateAccountRes account = client.accountClient.createAccount(req);
            System.out.println(account.getData());
            System.out.println("no exception");
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
    void TestQueryAccount() {
        QueryAccountsReq req = new QueryAccountsReq();
        //req.setOperationId("lmhaccount000002");
        try {
            QueryAccountsRes account = client.accountClient.queryAccounts(req);
            System.out.println(account.getData().getAccounts());
            System.out.println("no exception");
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}