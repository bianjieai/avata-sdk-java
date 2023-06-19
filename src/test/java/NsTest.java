import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.ns.*;
import org.junit.jupiter.api.Test;

public class NsTest {
    AvataClient client = new AvataClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();
    String OperationID = String.valueOf(System.currentTimeMillis());

    @Test
        //请求注册域名接口示例
    void TestRegisterDomain() {
        RegisterDomainReq req = new RegisterDomainReq();
        req.setName("");
        req.setOwner("");
        req.setDuration(1);
        req.setOperationId("registerdomain" + OperationID);
        try {
            PublicResponse res = client.nsClient.registerDomain(req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询域名接口示例
    void TestQueryDomain() {
        QueryDomainReq req = new QueryDomainReq();
        req.setName("");
        req.setTld("");
        try {
            QueryDomainRes res = client.nsClient.queryDomain(req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询用户域名接口示例
    void TestQueryOwnerDomain() {
        QueryOwnerDomainReq req = new QueryOwnerDomainReq();
        //req.setPageKey("");
        //req.setLimit("1");
        //req.setName("");
        //req.setTld("");
        req.setCountTotal("1");
        try {
            QueryOwnerDomainRes res = client.nsClient.queryOwnerDomain(req,
                    "");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求转让域名接口示例
    void TestTransferDomain() {
        TransferDomainReq req = new TransferDomainReq();
        req.setRecipient("");
        req.setOperationId("transferDomian" + OperationID);
        try {
            PublicResponse res = client.nsClient.transferDomain(req,
                    "",
                    "");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
