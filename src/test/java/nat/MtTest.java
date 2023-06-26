package nat;

import ai.bianjie.avatasdk.AvataNativeClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.nat.mt.*;
import org.junit.jupiter.api.Test;

public class MtTest {
    AvataNativeClient client = new AvataNativeClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();
    String OperationID = String.valueOf(System.currentTimeMillis());

    @Test
        //请求创建 MT 类别接口示例
    void TestCreateMtClass() {
        CreateMtClassReq req = new CreateMtClassReq();
        req.setName("");
        req.setOwner("");
        req.setData("");
        req.setOperationId("createmtclass" + OperationID);
        try {
            PublicResponse res = client.mtClient.createMtClass(req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询 MT 类别列表接口示例
    void TestQueryMtClasses() {
        QueryMtClassesReq req = new QueryMtClassesReq();
        req.setId("");
        req.setOwner("");
        QueryMtClassesRes res = client.mtClient.queryMtClasses(req);
        System.out.println(res.getData());
    }

    @Test
        //请求查询 MT 类别详情接口示例
    void TestQueryMtClass() {
        QueryMtClassRes res = client.mtClient.queryMtClass("");
        System.out.println(res.getData());
    }

    @Test
        //请求转让 MT 类别接口示例
    void TestTransferMtClass() {
        TransferMtClassReq req = new TransferMtClassReq();
        req.setRecipient("");
        req.setOperationId("transfermtclass" + OperationID);
        try {
            PublicResponse res = client.mtClient.transferMtClass(req,
                    "",
                    "");
            System.out.println(res.getData());
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求发行 MT 接口示例
    void TestCreateMt() {
        IssueMtReq req = new IssueMtReq();
        req.setData("");
        req.setAmount(1);
        req.setRecipient("");
        req.setOperationId("createmt" + OperationID);
        try {
            PublicResponse res = client.mtClient.createMt(req, "");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求增发 MT接口示例
    void TestMintMt() {
        MintMtReq req = new MintMtReq();
        req.setAmount(10);
        req.setRecipient("");
        req.setOperationId("mintmt" + OperationID);
        try {
            PublicResponse res = client.mtClient.mintMt(req,
                    "",
                    "");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求转让 MT 接口示例
    void TestTransferMt() {
        TransferMtReq req = new TransferMtReq();
        req.setAmount(10);
        req.setRecipient("");
        req.setOperationId("transfermt" + OperationID);
        try {
            PublicResponse res = client.mtClient.transferMt(req,
                    "",
                    "",
                    "");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求编辑 MT 接口示例
    void TestEditMt() {
        EditMtReq req = new EditMtReq();
        req.setData("789");
        req.setOperationId("editmt" + OperationID);
        try {
            PublicResponse res = client.mtClient.editMt(req,
                    "",
                    "",
                    "");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求销毁 MT 接口示例
    void TestDeleteMt() {
        BurnMtReq req = new BurnMtReq();
        req.setAmount(1);
        req.setOperationId("burnmt" + OperationID);
        try {
            PublicResponse res = client.mtClient.deleteMt(req,
                    "",
                    "",
                    "");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }


    @Test
        //请求查询 MT 列表接口示例
    void TestQueryMts() {
        QueryMtsReq req = new QueryMtsReq();
        req.setId("");
        QueryMtsRes res = client.mtClient.queryMts(req);
        System.out.println(res.getData());
    }

    @Test
        //请求查询 MT 详情接口示例
    void TestQueryMt() {
        QueryMtRes res = client.mtClient.queryMt(
                "",
                "");
        System.out.println(res.getData());
    }

    @Test
        //请求查询 MT 操作记录接口请求示例
    void TestQueryMtHistory() {
        QueryMtHistoryReq req = new QueryMtHistoryReq();
        QueryMtHistoryRes res = client.mtClient.queryMtHistory(req,
                "",
                "");
        System.out.println(res);
    }

    @Test
        //请求查询 MT 余额接口请求示例
    void TestQueryMtBalances() {
        QueryMtBalancesReq req = new QueryMtBalancesReq();
        req.setId("");
        QueryMtBalancesRes res = client.mtClient.queryMtBalances(req,
                "",
                "");
        System.out.println(res);
    }
}
