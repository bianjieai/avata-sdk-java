import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.account.*;
import org.junit.jupiter.api.Test;

public class AccountTest {
    AvataClient client = new AvataClient.Builder()
            .setDomain("https://stage.apis.avata.bianjie.ai")
            .setApiKey("N282j1X1E1K6h0k1U3b4A3a9G4B7g86Q")
            .setApiSecret("M2t2B1m1H1U6E0u1g3a4Y3f9p4k7y92G")
            .setHttpTimeout(10000)
            .init();

    String OperationID = String.valueOf(System.currentTimeMillis());

    @Test
        //请求创建链账户接口示例
    void TestCreateAccount() {
        CreateAccountReq req = new CreateAccountReq();
        req.setName("21233");
        req.setOperationId("234231");
        try {
            CreateAccountRes account = client.accountClient.createAccount(req);
            System.out.println(account.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询链账户接口示例
    void TestQueryAccount() {
        QueryAccountsReq req = new QueryAccountsReq();
        req.setLimit("3");
        try {
            QueryAccountsRes account = client.accountClient.queryAccounts(req);
            System.out.println(account.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求批量创建链账户接口示例
    void TestBatchCreateAccount() {
        BatchCreateAccountReq req = new BatchCreateAccountReq();
        req.setCount(2);
        req.setOperationId(OperationID);
        try {
            BatchCreateAccountRes account = client.accountClient.batchCreateAccounts(req);
            System.out.println(account.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询链账户操作记录接口示例
    void TestQueryAccountHistory() {
        QueryAccountsHistoryReq req = new QueryAccountsHistoryReq();
        req.setLimit("2");
        try {
            QueryAccountsHistoryRes account = client.accountClient.queryAccountsHistory(req);
            System.out.println(account.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}