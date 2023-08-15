import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.account.*;
import ai.bianjie.avatasdk.model.account.QueryNativeAccountsHistoryRes;
import org.junit.jupiter.api.Test;


public class AccountTest {
    AvataClient client = new AvataClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();

    String OperationID = String.valueOf(System.currentTimeMillis());

    @Test
        //请求创建链账户接口示例
    void TestCreateAccount() {
        CreateAccountReq req = new CreateAccountReq();
        req.setName("lmhtest");
        req.setOperationId("createaccount" + OperationID);
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
        //req.setPageKey("");
        //req.setLimit("3");
        //req.setAccount("");
        // req.setName("");
        //req.setOperationId("");
        //req.setStartDate("");
        //req.setEndDate("");
        //req.setSortBy("");
        req.setCountTotal("1");
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
        req.setCount(1);
        req.setOperationId("batchcreateaccount" + OperationID);
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
        //原生项目：请求查询链账户操作记录接口示例
    void TestQueryNativeAccountHistory() {
        QueryAccountsHistoryReq req = new QueryAccountsHistoryReq();
        //req.setPageKey("");
        //req.setLimit("");
        req.setAccount("iaa1jjmwg5ah27aynuwt2phwa8sfvzh4lvvlelddxm");
        try {
            QueryNativeAccountsHistoryRes account = client.accountClient.queryNativeAccountsHistory(req);
            System.out.println(account.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //EVM 项目：请求查询链账户操作记录接口示例
    void TestQueryEvmAccountHistory() {
        QueryAccountsHistoryReq req = new QueryAccountsHistoryReq();
        //req.setPageKey("");
        //req.setLimit("");
        try {
            QueryNativeAccountsHistoryRes account = client.accountClient.queryEvmAccountsHistory(req);
            System.out.println(account.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}