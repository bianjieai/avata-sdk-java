package ai.bianjie.avatasdktest;

import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.account.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AccountTest {
    private AvataClient client;

    @BeforeEach
    public void init() {
        client = AvataClientTest.getAvataClient();
    }

    @Test
        //请求创建链账户接口示例
    void TestCreateAccount() {
        CreateAccountReq req = new CreateAccountReq();
        req.setName("lmhtest");
        req.setOperationId("createaccount");
        try {
            CreateAccountRes account = client.account.createAccount(req);
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
            QueryAccountsRes account = client.account.queryAccounts(req);
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
        req.setOperationId("batchcreateaccount");
        try {
            BatchCreateAccountRes account = client.account.batchCreateAccounts(req);
            System.out.println(account.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //原生模块：请求查询链账户操作记录接口示例
    void TestQueryNativeAccountHistory() {
        QueryAccountsHistoryReq req = new QueryAccountsHistoryReq();
        //req.setPageKey("");
        //req.setLimit("");
        req.setAccount("iaa1jjmwg5ah27aynuwt2phwa8sfvzh4lvvlelddxm");
        try {
            QueryNatAccountsHistoryRes account = client.account.queryNativeAccountsHistory(req);
            System.out.println(account.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //EVM 模块：请求查询链账户操作记录接口示例
    void TestQueryEvmAccountHistory() {
        QueryAccountsHistoryReq req = new QueryAccountsHistoryReq();
        //req.setPageKey("");
        //req.setLimit("");
        try {
            QueryEvmAccountsHistoryRes account = client.account.queryEvmAccountsHistory(req);
            System.out.println(account.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}