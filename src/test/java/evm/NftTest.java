package evm;

import ai.bianjie.avatasdk.AvataEvmClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.evm.nft.*;
import org.junit.jupiter.api.Test;

public class NftTest {
    AvataEvmClient client = new AvataEvmClient.Builder()
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
        req.setUri("");
        req.setSymbol("");
        req.setOwner("");
        req.setEditableByOwner(1);
        req.setEditableByClassOwner(1);
        req.setOperationId("createnftclass" + OperationID);
        try {
            PublicResponse res = client.nftClient.createNftClass(req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询 NFT 类别列表接口示例
    void TestQueryNftClasses() {
        QueryNftClassesReq req = new QueryNftClassesReq();
        req.setPageKey("");
        req.setLimit("");
        req.setId("");
        req.setName("");
        req.setOwner("");
        req.setTxHash("");
        req.setStartDate("");
        req.setEndDate("");
        req.setCountTotal("1");
        req.setId("");
        try {
            QueryNftClassesRes res = client.nftClient.queryNftClasses(req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询 NFT 类别详情接口示例
    void TestQueryNftClass() {
        try {
            QueryNftClassRes res = client.nftClient.queryNftClass("");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求转让 NFT 类别接口示例
    void TestTransferNftClass() {
        TransferNftClassReq req = new TransferNftClassReq();
        req.setRecipient("");
        req.setOperationId("transfernftclass" + OperationID);
        try {
            PublicResponse res = client.nftClient.transferNftClass(req,
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
    void TestMintNft() {
        MintNftReq req = new MintNftReq();
        req.setUri("");
        req.setUriHash("");
        req.setRecipient("");
        req.setOperationId("mintnft" + OperationID);
        try {
            PublicResponse res = client.nftClient.mintNft(req,
                    "");
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
            PublicResponse res = client.nftClient.transferNft(req,
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
        req.setUri("");
        req.setUriHash("");
        req.setOperationId("editnft" + OperationID);
        try {
            PublicResponse res = client.nftClient.editNft(req,
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
            PublicResponse res = client.nftClient.burnNft(req,
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
        try {
            QueryNftsReq req = new QueryNftsReq();
            req.setPageKey("");
            req.setLimit("");
            req.setId("");
            req.setClassId("");
            req.setOwner("");
            req.setTxHash("");
            req.setStatus("");
            req.setStartDate("");
            req.setEndDate("");
            req.setSortBy("");
            req.setCountTotal("1");
            QueryNftsRes res = client.nftClient.queryNfts(req);
            System.out.println(res.getData());
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询 NFT 详情接口示例
    void TestQueryNft() {
        try {
            QueryNftRes res = client.nftClient.queryNft(
                    "",
                    "");
            System.out.println(res.getData());
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询 NFT 操作记录接口示例
    void TestQueryNftHistory() {
        try {
            QueryNftHistoryReq req = new QueryNftHistoryReq();
            req.setLimit("2");
            QueryNftHistoryRes res = client.nftClient.queryNftHistory(
                    "",
                    "", req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
