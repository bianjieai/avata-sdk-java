import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.account.*;
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
        //req.setUserId("");
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
        //req.setPageKey("587mvF9aNXbGhFK8jaLdK4gFJPuIuO3U73nz/QIj59r8689f6d7j9G8usCj1zYY0sYqvERiqErB9l6OeZfVDzxyVJN6XGv9nAIlzs3tY2FOxrm5YO2Yl0jirFa9KXSmGAKApeVypCB7pnFjl");
        //req.setLimit("3");
        //req.setUserId("");
        //req.setAccount("0xd83DC58D586654D6067747b489EB8882F855669e");
        //req.setName("");
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
        req.setCount(10);
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
        //请求查询链账户操作记录接口示例
    void TestQueryAccountHistory() {
        QueryAccountsHistoryReq req = new QueryAccountsHistoryReq();
        req.setModule("1");
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