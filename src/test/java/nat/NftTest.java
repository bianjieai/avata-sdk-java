package nat;

import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.nat.nft.*;
import org.junit.jupiter.api.Test;

public class NftTest {
    AvataClient client = new AvataClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();

    String OperationID = String.valueOf(System.currentTimeMillis());

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
        req.setOperationId("createnftclass" + OperationID);
        try {
            PublicResponse res = client.nativeClient.nftClient.createClass(req);
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
        QueryNftClassesRes res = client.nativeClient.nftClient.queryClasses(req);
        System.out.println(res.getData());
    }

    @Test
        //请求查询 NFT 类别详情接口示例
    void TestQueryClass() {
        QueryNftClassRes res = client.nativeClient.nftClient.queryClass("");
        System.out.println(res.getData());
    }

    @Test
        //请求转让 NFT 类别接口示例
    void TestTransferClass() {
        TransferNftClassReq req = new TransferNftClassReq();
        req.setRecipient("");
        req.setOperationId("transfernftclass" + OperationID);
        try {
            PublicResponse res =client.nativeClient.nftClient.transferClass(req,
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
        req.setOperationId("mintnft" + OperationID);
        try {
            PublicResponse res = client.nativeClient.nftClient.createNft(req, "bakvavoy");
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
        req.setOperationId("transfernft" + OperationID);
        try {
            PublicResponse res = client.nativeClient.nftClient.transferNft(req,
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
        req.setOperationId("editnft" + OperationID);
        try {
            PublicResponse res = client.nativeClient.nftClient.editNft(req,
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
        req.setOperationId("burnnft" + OperationID);
        try {
            PublicResponse res = client.nativeClient.nftClient.burnNft(req,
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
        QueryNftsRes res = client.nativeClient.nftClient.queryNfts(req);
        System.out.println(res.getData());
    }

    @Test
        //请求查询 NFT 详情接口示例
    void TestQueryNft() {
        QueryNftRes res = client.nativeClient.nftClient.queryNft(
                "",
                "");
        System.out.println(res.getData());
    }

    @Test
        //请求查询 NFT 操作记录接口示例
    void TestQueryNftHistory() {
        QueryNftHistoryReq req = new QueryNftHistoryReq();
        req.setLimit("2");
        QueryNftHistoryRes res = client.nativeClient.nftClient.queryNftHistory(
                "",
                "", req);
        System.out.println(res.getData());
    }
}
