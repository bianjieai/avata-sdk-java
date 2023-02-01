import model.PublicResponse;
import model.mt.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MtTest {
    Client client = new Client.Builder()
            .setDoMain("http://192.168.150.41:18081")
            .setApiKey("000001")
            .setApiSecret("ceshi")
            .setHttpTimeout(10000)
            .init();
    String OperationID = String.valueOf(System.currentTimeMillis());

    @Test
        //请求创建 MT 类别接口示例
    void TestCreateMtClass() {
        CreateMtClassReq req = new CreateMtClassReq();
        req.setName("lmhmtclassname01");
        req.setOwner("iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl");
        req.setData("123");
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "1");
        req.setOperationId(OperationID);
        try {
            PublicResponse res = client.mtClient.createMtClass(req);
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询 MT 类别列表接口示例
    void TestQueryMtClasses() {
        QueryMtClassesReq req = new QueryMtClassesReq();
        req.setId("4f15f17298001ffcdce757d068dba933ef73193e6a261cb9d0f472a2ced1d756");
        req.setOwner("iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl");
        QueryMtClassesRes res = client.mtClient.queryMtClasses(req);
        System.out.println(res.getData());
    }

    @Test
        //请求查询 MT 类别详情接口示例
    void TestQueryMtClass() {
        QueryMtClassRes res = client.mtClient.queryMtClass("4f15f17298001ffcdce757d068dba933ef73193e6a261cb9d0f472a2ced1d756");
        System.out.println(res.getData());
    }

    @Test
        //请求转让 MT 类别接口示例
    void TestTransferMtClass() {
        TransferMtClassReq req = new TransferMtClassReq();
        req.setRecipient("iaa1jxf58dswgfqs84vw57wzucmttda3s3eu8dhcgr");
        req.setOperationId(OperationID);
        try {
            PublicResponse res = client.mtClient.transferMtClass(req,
                    "4f15f17298001ffcdce757d068dba933ef73193e6a261cb9d0f472a2ced1d756",
                    "iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl");
            System.out.println(res.getData().getOperationId());
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求发行 MT 接口示例
    void TestCreateMt() {
        CreateMtReq req = new CreateMtReq();
        req.setData("datadata");
        req.setAmount(100);
        req.setRecipient("iaa1jxf58dswgfqs84vw57wzucmttda3s3eu8dhcgr");
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "2");
        req.setOperationId(OperationID);
        try {
            PublicResponse res = client.mtClient.createMt(req, "4f15f17298001ffcdce757d068dba933ef73193e6a261cb9d0f472a2ced1d756");
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
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
        req.setRecipient("iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl");
        req.setOperationId(OperationID);
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "3");
        try {
            PublicResponse res = client.mtClient.mintMt(req,
                    "4f15f17298001ffcdce757d068dba933ef73193e6a261cb9d0f472a2ced1d756",
                    "f676009a34102e0f9396da8d2f372790ee813c96a17ba91b797bdee57aa041a9");
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
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
        req.setRecipient("iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl");
        req.setOperationId(OperationID);
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "3");
        try {
            PublicResponse res = client.mtClient.transferMt(req,
                    "4f15f17298001ffcdce757d068dba933ef73193e6a261cb9d0f472a2ced1d756",
                    "iaa1jxf58dswgfqs84vw57wzucmttda3s3eu8dhcgr",
                    "f676009a34102e0f9396da8d2f372790ee813c96a17ba91b797bdee57aa041a9");
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
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
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "3");
        req.setOperationId(OperationID);
        try {
            PublicResponse res = client.mtClient.editMt(req,
                    "4f15f17298001ffcdce757d068dba933ef73193e6a261cb9d0f472a2ced1d756",
                    "iaa1jxf58dswgfqs84vw57wzucmttda3s3eu8dhcgr",
                    "f676009a34102e0f9396da8d2f372790ee813c96a17ba91b797bdee57aa041a9");
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求销毁 MT 接口示例
    void TestDeleteMt() {
        DeleteMtReq req = new DeleteMtReq();
        req.setAmount(1);
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "4");
        req.setOperationId(OperationID);
        try {
            PublicResponse res = client.mtClient.deleteMt(req,
                    "4f15f17298001ffcdce757d068dba933ef73193e6a261cb9d0f472a2ced1d756",
                    "iaa1jxf58dswgfqs84vw57wzucmttda3s3eu8dhcgr",
                    "f676009a34102e0f9396da8d2f372790ee813c96a17ba91b797bdee57aa041a9");
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }


    @Test
        //请求查询 MT 列表接口示例
    void TestQueryMts() {
        QueryMtsReq req = new QueryMtsReq();
        req.setId("f676009a34102e0f9396da8d2f372790ee813c96a17ba91b797bdee57aa041a9");
        QueryMtsRes res = client.mtClient.queryMts(req);
        System.out.println(res.getData());
    }

    @Test
        //请求查询 MT 详情接口示例
    void TestQueryMt() {
        QueryMtRes res = client.mtClient.queryMt(
                "4f15f17298001ffcdce757d068dba933ef73193e6a261cb9d0f472a2ced1d756",
                "f676009a34102e0f9396da8d2f372790ee813c96a17ba91b797bdee57aa041a9");
        System.out.println(res.getData());
    }

    @Test
        //请求查询 MT 操作记录接口请求示例
    void TestQueryMtHistory() {
        QueryMtHistoryReq req = new QueryMtHistoryReq();
        req.getOffset();
        QueryMtHistoryRes res = client.mtClient.queryMtHistory(req,
                "4f15f17298001ffcdce757d068dba933ef73193e6a261cb9d0f472a2ced1d756",
                "f676009a34102e0f9396da8d2f372790ee813c96a17ba91b797bdee57aa041a9");
        System.out.println(res);
    }

    @Test
        //请求查询 MT 余额接口请求示例
    void TestQueryMtBalances() {
        QueryMtBalancesReq req = new QueryMtBalancesReq();
        req.getId();
        QueryMtBalancesRes res = client.mtClient.queryMtBalances(req,
                "4f15f17298001ffcdce757d068dba933ef73193e6a261cb9d0f472a2ced1d756",
                "iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl");
        System.out.println(res);
    }
}
