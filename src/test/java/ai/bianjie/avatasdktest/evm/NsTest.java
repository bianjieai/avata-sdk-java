package ai.bianjie.avatasdktest.evm;

import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.evm.ns.*;
import ai.bianjie.avatasdktest.AvataClientTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NsTest {
    private AvataClient client;

    @BeforeEach
    public void init() {
        client = AvataClientTest.getAvataClient();
    }
    @Test
        //请求注册域名接口示例
    void TestRegisterDomain() {
        RegisterDomainReq req = new RegisterDomainReq();
        req.setName("");
        req.setOwner("");
        req.setDuration(1);
        req.setOperationId("registerdomain");
        try {
            PublicResponse res = client.evmClient.nsClient.registerDomain(req);
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
            QueryDomainRes res =client.evmClient.nsClient.queryDomain(req);
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
        req.setPageKey("");
        req.setLimit("1");
        req.setName("");
        req.setTld("");
        req.setCountTotal("1");
        try {
            QueryOwnerDomainRes res = client.evmClient.nsClient.queryOwnerDomain(req,
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
        req.setOperationId("transferDomian");
        try {
            PublicResponse res = client.evmClient.nsClient.transferDomain(req,
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
        //请求设置域名解析接口示例
    void TestResolveDomain() {
        ResolveDomainReq req = new ResolveDomainReq();
        req.setResolveType(1);
        ResolveDomainReq.AddrDTO addrDTO = new ResolveDomainReq.AddrDTO();
        req.setAddrDTO(addrDTO);
        addrDTO.setAddrValue("");
        addrDTO.setBlockChain(1002);
        //req.setResolveType(2);
        //ResolveDomainReq.TextDTO textDTO = new ResolveDomainReq.TextDTO();
        //req.setTextDTO(textDTO);
        //textDTO.setKey("");
        //textDTO.setTextValue("");
        req.setOperationId("resolveDomain");
        try {
            PublicResponse res = client.evmClient.nsClient.ResolveDomain(req,
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
        //设置查询域名解析接口示例
    void TestQueryDomainResolves() {
        QueryDomainResolvesReq req = new QueryDomainResolvesReq();
        req.setResolveType(0);
        try {
            QueryDomainResolvesRes res = client.evmClient.nsClient.queryDomainResolves(
                    "", req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //设置域名反向解析接口示例
    void TestReverseResolveDomain() {
        ReverseResolveDomainReq req = new ReverseResolveDomainReq();
        req.setName("");
        req.setOperationId("");
        try {
            PublicResponse res = client.evmClient.nsClient.reverseResolveDomain(req,
                    "");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        // 查询域名反向解析接口示例
    void TestQueryReverseResolveDomain() {
        try {
            QueryReverseResolveDomainRes res = client.evmClient.nsClient.queryReverseResolveDomain(
                    "");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (
                Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}