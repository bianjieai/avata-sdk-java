package ai.bianjie.avatasdktest.nat;

import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.nat.nft.*;
import ai.bianjie.avatasdktest.AvataClientTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NftTest {
    private AvataClient client;

    @BeforeEach
    public void init() {
        client = AvataClientTest.getAvataClient();
    }

    @Test
        //请求创建 NFT 类别接口示例
    void TestCreateClass() {
        CreateNftClassReq req = new CreateNftClassReq();
        req.setName("");
        req.setClassId("");
        req.setSymbol("");
        req.setDescription("");
        req.setUri("");
        req.setUriHash("");
        req.setData("");
        req.setOwner("");
        req.setOperationId("createnftclass");
        try {
            PublicResponse res = client.nat.nft.createClass(req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询 NFT 类别列表接口示例
    void TestQueryClasses() {
        QueryNftClassesReq req = new QueryNftClassesReq();
        req.setId("");
        req.setOwner("");
        QueryNftClassesRes res = client.nat.nft.queryClasses(req);
        System.out.println(res.getData());
    }

    @Test
        //请求查询 NFT 类别详情接口示例
    void TestQueryClass() {
        QueryNftClassRes res = client.nat.nft.queryClass("");
        System.out.println(res.getData());
    }

    @Test
        //请求转让 NFT 类别接口示例
    void TestTransferClass() {
        TransferNftClassReq req = new TransferNftClassReq();
        req.setRecipient("");
        req.setOperationId("transfernftclass");
        try {
            PublicResponse res =client.nat.nft.transferClass(req,
                    "",
                    "");
            System.out.println(res.getData());
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求发行 NFT 接口示例
    void TestCreateNft() {
        MintNftReq req = new MintNftReq();
        req.setName("");
        req.setUri("");
        req.setUriHash("");
        req.setData("");
        req.setRecipient("");
        req.setOperationId("mintnft");
        try {
            PublicResponse res = client.nat.nft.createNft(req, "bakvavoy");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求转让 NFT 接口示例
    void TestTransferNft() {
        TransferNftReq req = new TransferNftReq();
        req.setRecipient("");
        req.setOperationId("transfernft");
        try {
            PublicResponse res = client.nat.nft.transferNft(req,
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
        //请求编辑 NFT 接口示例
    void TestEditNft() {
        EditNftReq req = new EditNftReq();
        req.setName("");
        req.setUri("");
        req.setData("");
        req.setOperationId("editnft");
        try {
            PublicResponse res = client.nat.nft.editNft(req,
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
        //请求销毁 NFT 接口示例
    void TestDeleteNft() {
        BurnNftReq req = new BurnNftReq();
        req.setOperationId("burnnft");
        try {
            PublicResponse res = client.nat.nft.burnNft(req,
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
        //请求查询 NFT 列表接口示例
    void TestQueryNfts() {
        QueryNftsReq req = new QueryNftsReq();
        req.setLimit("2");
        req.setStatus("2");
        QueryNftsRes res = client.nat.nft.queryNfts(req);
        System.out.println(res.getData());
    }

    @Test
        //请求查询 NFT 详情接口示例
    void TestQueryNft() {
        QueryNftRes res = client.nat.nft.queryNft(
                "",
                "");
        System.out.println(res.getData());
    }

    @Test
        //请求查询 NFT 操作记录接口示例
    void TestQueryNftHistory() {
        QueryNftHistoryReq req = new QueryNftHistoryReq();
        req.setLimit("2");
        QueryNftHistoryRes res = client.nat.nft.queryNftHistory(
                "",
                "", req);
        System.out.println(res.getData());
    }
}
