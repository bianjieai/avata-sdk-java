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
        req.setName("刘明慧创建 EVM NFT 类别1");
        req.setUri("http://www.lmhzd6.com");
        req.setSymbol("刘明慧真滴6");
        req.setOwner("0x94C02B7c976f9fc5624fDb510C84E5265E90e579");
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
        //req.setPageKey("587mvF9aNXbGhFK8jaLdK4gFJPuLls/W7Hn3/AENxZMmi5LXDGL2KgBPlby1Ur2BHsciSYVnH1Y6eruebB3pn+hPEjsqLe9FIr3RcSZhUspNDESkSjcEzBq6c/SIvLBRBlsQJalyErE=");
        // req.setLimit("2");
        //req.setId("0xA22f8867E57158670cB8F4368fD1e0e31d409Dc1");
        //req.setName("刘明慧");
        //req.setOwner("0x5006f6b52325e370A181556456D38631c01F682e");
        //req.setTxHash("0x63ae6ea3156a4a9a6f02e3e189fe8a6e45c706c1b8da4c10bb96b8b33b743ce0");
        // req.setStartDate("2023-04-06");
        //req.setEndDate("2023-04-10");
        req.setCountTotal("1");
        //req.setId("0x7D3FBf198b3F5d9f8fc3E5312692aB32C472995B");
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
            QueryNftClassRes res = client.nftClient.queryNftClass("0x7D3FBf198b3F5d9f8fc3E5312692aB32C472995B");
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
        req.setRecipient("0x8e954eeBFb8cdc20aCa3cC95c5558EBD5E65823E");
        req.setOperationId("transfernftclass" + OperationID);
        try {
            PublicResponse res = client.nftClient.transferNftClass(req, "0x7D3FBf198b3F5d9f8fc3E5312692aB32C472995B", "0x5006f6b52325e370A181556456D38631c01F682e");
            System.out.println(res.getData());
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }// transfernftclass1681209295067

    @Test
        //请求发行 NFT 接口示例
    void TestMintNft() {
        MintNftReq req = new MintNftReq();
        req.setUri("http://www.456.com");
        req.setUriHash("456");
        req.setRecipient("0x5006f6b52325e370A181556456D38631c01F682e");
        req.setOperationId("mintnft" + OperationID);
        try {
            PublicResponse res = client.nftClient.mintNft(req, "0x7D3FBf198b3F5d9f8fc3E5312692aB32C472995B");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }//mintnft1681209607790, mintnft1681266598724
    }

    @Test
        //请求转让 NFT 接口示例
    void TestTransferNft() {
        TransferNftReq req = new TransferNftReq();
        req.setRecipient("0x8e954eeBFb8cdc20aCa3cC95c5558EBD5E65823E");
        req.setOperationId("transfernft" + OperationID);
        try {
            PublicResponse res = client.nftClient.transferNft(req, "0x7D3FBf198b3F5d9f8fc3E5312692aB32C472995B", "0x5006f6b52325e370A181556456D38631c01F682e", "3");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }// transfernft1681267080404
    }

    @Test
        //请求编辑 NFT 接口示例
    void TestEditNft() {
        EditNftReq req = new EditNftReq();
        req.setUri("http://www.789.com");
        req.setUriHash("erytfugybiunj");
        req.setOperationId("editnft" + OperationID);
        try {
            PublicResponse res = client.nftClient.editNft(req, "0x7D3FBf198b3F5d9f8fc3E5312692aB32C472995B", "0x8e954eeBFb8cdc20aCa3cC95c5558EBD5E65823E", "1");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }//editnft1681280034661
    }

    @Test
        //请求销毁 NFT 接口示例
    void TestDeleteNft() {
        BurnNftReq req = new BurnNftReq();
        req.setOperationId("burnnft" + OperationID);
        try {
            PublicResponse res = client.nftClient.burnNft(req, "0x7D3FBf198b3F5d9f8fc3E5312692aB32C472995B", "0x8e954eeBFb8cdc20aCa3cC95c5558EBD5E65823E", "1");
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }//burnnft1681280847393

    @Test
        //请求查询 NFT 列表接口示例
    void TestQueryNfts() {
        try {
            QueryNftsReq req = new QueryNftsReq();
            req.setPageKey("587mvF9aNXbGhFK8jaKqJJja+JN6ncbAHqffSFYT1gKR1ZwHcGEtXPcIi9jHqTL5ONr+wG1D9KBOUQnVP2Mc6CTBfsJsl8OUoSrnXE7GTps8UWyBdmGKzbxKfDI2CgxRXY3gVb0v1B2psr/6ff6ilk57IKqku32YSRG1bg==");
            // req.setLimit("2");
            // req.setId("1");
            // req.setClassId("0x7D3FBf198b3F5d9f8fc3E5312692aB32C472995B");
            // req.setOwner("0x8e954eeBFb8cdc20aCa3cC95c5558EBD5E65823E");
            // req.setTxHash("0x3493937f28253d09dd8cf2ce82eedf66c10e9d48056739c0556015f7404fe5b5");
            // req.setStatus("2");
            req.setStartDate("2023-04-10");
            req.setEndDate("2023-04-10");
            req.setSortBy("DATE_ASC");
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
            QueryNftRes res = client.nftClient.queryNft("0x7D3FBf198b3F5d9f8fc3E5312692aB32C472995B", "2");
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
            QueryNftHistoryRes res = client.nftClient.queryNftHistory("0x7D3FBf198b3F5d9f8fc3E5312692aB32C472995B", "1", req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
