import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.nft.*;
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
    void TestCreateNftClass() {
        CreateNftClassReq req = new CreateNftClassReq();
        req.setName("lmh创建NFT类别1");
        req.setUri("http://www.lmhzd6.com");
        req.setSymbol("lmh");
        req.setOwner("0xd83DC58D586654D6067747b489EB8882F855669e");
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
        req.setPageKey("587mvF9aNXbGhFK8jaLdK4gFJPuIqMua7Wn/sQIz854UrrbqNhsQ/VzlFXb1WXw/QJl6n5RaQZCt1NQsgw5A3sbfTvBaw/KO0fhm4f2vqV760mJdxxLKkth3miukMc6xjSqHaQPqEUk=");
        req.setLimit("2");
        //req.setId("0xA22f8867E57158670cB8F4368fD1e0e31d409Dc1");
        //req.setName("");
        //req.setOwner("0xd83DC58D586654D6067747b489EB8882F855669e");
        //req.setTxHash("");
        // req.setStartDate("");
        //req.setEndDate("");
        //req.setCountTotal("1");
        //req.setId("");
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
            QueryNftClassRes res = client.nftClient.queryNftClass(
                    "0xD78655F910eB4A6Ec095332FcD3E6Eb155E0D414");
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
        req.setRecipient("0xff5708A68B7cd79CecE27017Ee89eb90566141f3");
        req.setOperationId("transfernftclass" + OperationID);
        try {
            PublicResponse res = client.nftClient.transferNftClass(req,
                    "0xD78655F910eB4A6Ec095332FcD3E6Eb155E0D414",
                    "0xd83DC58D586654D6067747b489EB8882F855669e");
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
        req.setUri("http://www.456.com");
        req.setUriHash("456");
        req.setRecipient("0xff5708A68B7cd79CecE27017Ee89eb90566141f3");
        req.setOperationId("mintnft" + OperationID);
        try {
            PublicResponse res = client.nftClient.mintNft(req,
                    "0xD78655F910eB4A6Ec095332FcD3E6Eb155E0D414");
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
        req.setRecipient("0xd83DC58D586654D6067747b489EB8882F855669e");
        req.setOperationId("transfernft" + OperationID);
        try {
            PublicResponse res = client.nftClient.transferNft(req,
                    "0xD78655F910eB4A6Ec095332FcD3E6Eb155E0D414",
                    "0xff5708A68B7cd79CecE27017Ee89eb90566141f3",
                    "1");
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
        req.setUri("http://www.789.com");
        req.setUriHash("erytfugybiunj");
        req.setOperationId("editnft" + OperationID);
        try {
            PublicResponse res = client.nftClient.editNft(req,
                    "0xD78655F910eB4A6Ec095332FcD3E6Eb155E0D414",
                    "0xd83DC58D586654D6067747b489EB8882F855669e",
                    "1");
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
                    "0xD78655F910eB4A6Ec095332FcD3E6Eb155E0D414",
                    "0xd83DC58D586654D6067747b489EB8882F855669e",
                    "1");
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
            //req.setLimit("2");
            //req.setId("1");
            //req.setClassId("0x7D3FBf198b3F5d9f8fc3E5312692aB32C472995B");
            //req.setOwner("0x8e954eeBFb8cdc20aCa3cC95c5558EBD5E65823E");
            //req.setTxHash("0x3493937f28253d09dd8cf2ce82eedf66c10e9d48056739c0556015f7404fe5b5");
            //req.setStatus("2");
            //req.setStartDate("2023-04-10");
            //req.setEndDate("2023-04-10");
            //req.setSortBy("DATE_ASC");
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
                    "0x7D3FBf198b3F5d9f8fc3E5312692aB32C472995B",
                    "2");
            System.out.println(res);
            System.out.println("no ai.bianjie.avatasdk.exception");
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
                    "0x7D3FBf198b3F5d9f8fc3E5312692aB32C472995B",
                    "1", req);
            System.out.println(res);
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
