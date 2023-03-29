import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.account.*;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class AccountTest {

    private final static String URL = "";
    private final static String API_KEY = "";
    private final static String API_SECRET = "";


    AvataClient client = new AvataClient.Builder()
            .setDomain(URL)
            .setApiKey(API_KEY)
            .setApiSecret(API_SECRET)
            .setHttpTimeout(10000)
            .init();

    String OperationID = String.valueOf(System.currentTimeMillis());

    @Test
        //请求创建链账户接口示例
    void TestCreateAccount() {
        CreateAccountReq req = new CreateAccountReq();
        req.setName("huangjianfeng");
        req.setOperationId(UUID.randomUUID().toString());
        req.setUserId("huangjianfeng");
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