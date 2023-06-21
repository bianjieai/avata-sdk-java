package evm;

import ai.bianjie.avatasdk.AvataEvmClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.evm.ns.*;
import org.junit.jupiter.api.Test;

public class NsTest {
    AvataEvmClient client = new AvataEvmClient.Builder()
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
        //req.setPageKey("587mvF9aNXbGhFK8jaLdK4gFJPuIuOHX7HnvsAEdxdgvfDwGyfVsMpNAo36kBIInzHv4Jq3rXzNurPdeoUaH/WXvg-3pzz/y7-x74PIne/wS-fg0aQjSHKoxssXyc6TL-f06LyfRUmY=");
        //req.setLimit("1");
        //req.setName("lmhtest");
        //req.setTld("w");
        //req.setCountTotal("1");
        try {
            QueryOwnerDomainRes res = client.nsClient.queryOwnerDomain(req, "0x1bBC0Cf1C37d34aFc9FF2d18161EA7cFe3839fD1");
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
        req.setRecipient("0x031B739E95F83cB006AB79bD15664eF38c607883");
        req.setOperationId("transferDomian" + OperationID);
        try {
            PublicResponse res = client.nsClient.transferDomain(req, "0x1bBC0Cf1C37d34aFc9FF2d18161EA7cFe3839fD1", "lmhtest.wallet");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }


}
