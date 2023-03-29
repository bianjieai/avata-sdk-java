import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.nft.*;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class NftTest {
    private final static String URL = "";
    private final static String API_KEY = "";
    private final static String API_SECRET = "";


    AvataClient client = new AvataClient.Builder()
            .setDomain(URL)
            .setApiKey(API_KEY)
            .setApiSecret(API_SECRET)
            .setHttpTimeout(10000)
            .init();


    String OperationID = String.valueOf(System.currentTimeMillis());

    @Test
        //请求创建 NFT 类别接口示例
    void TestCreateClass() {
        CreateNftClassReq req = new CreateNftClassReq();
        req.setName("测试分类12");
        req.setSymbol("测试分类12");
        req.setOwner("0x41acB9fb3A04756Ae679c6dbEF39eE3A9F9AECd3");
        req.setOperationId(UUID.randomUUID().toString());
        try {
            PublicResponse res = client.nftClient.createClass(req);
            System.out.println(res.getData().getOperationId());
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
        req.setId("bakvavoy");
        req.setOwner("iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl");
        QueryNftClassesRes res = client.nftClient.queryClasses(req);
        System.out.println(res.getData());
    }

    @Test
        //请求查询 NFT 类别详情接口示例
    void TestQueryClass() {
        QueryNftClassRes res = client.nftClient.queryClass("bakvavoy");
        System.out.println(res.getData());
    }

    @Test
        //请求转让 NFT 类别接口示例
    void TestTransferClass() {
        TransferNftClassReq req = new TransferNftClassReq();
        req.setRecipient("iaa1jxf58dswgfqs84vw57wzucmttda3s3eu8dhcgr");
        req.setOperationId(UUID.randomUUID().toString());
        try {
            PublicResponse res = client.nftClient.transferClass(req,
                    "bakvavoy",
                    "iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl");
            System.out.println(res.getData().getOperationId());
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求发行 NFT 接口示例
    void TestCreateNft() {
        MintNftReq req = new MintNftReq();
        req.setUri("http://www.123.com");
        req.setUriHash("456");
        req.setRecipient("0xAb7bF109170FaA8338ab2FCb2Fe6f138a797259a");
        req.setOperationId(UUID.randomUUID().toString());
        try {
            PublicResponse res = client.nftClient.createNft(req, "0x3EC696de2925616a5A35ebD59B703Cc8f44B8Aa7");
            System.out.println(res.getData().getOperationId());
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
        req.setRecipient("0x41acB9fb3A04756Ae679c6dbEF39eE3A9F9AECd3");
        req.setOperationId(UUID.randomUUID().toString());
        try {
            PublicResponse res = client.nftClient.transferNft(req,
                    "0x3EC696de2925616a5A35ebD59B703Cc8f44B8Aa7",
                    "0xAb7bF109170FaA8338ab2FCb2Fe6f138a797259a",
                    "4");
            System.out.println(res.getData().getOperationId());
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
        req.setOperationId(UUID.randomUUID().toString());
        try {
            PublicResponse res = client.nftClient.editNft(req,
                    "0x3EC696de2925616a5A35ebD59B703Cc8f44B8Aa7",
                    "0xAb7bF109170FaA8338ab2FCb2Fe6f138a797259a",
                    "5");
            System.out.println(res.getData().getOperationId());
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
        req.setOperationId(UUID.randomUUID().toString());
        try {
            PublicResponse res = client.nftClient.burnNft(req,
                    "0x3EC696de2925616a5A35ebD59B703Cc8f44B8Aa7",
                    "0xAb7bF109170FaA8338ab2FCb2Fe6f138a797259a",
                    "5");
            System.out.println(res.getData().getOperationId());
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
        req.setStatus("burned");
        QueryNftsRes res = client.nftClient.queryNfts(req);
        System.out.println(res.getData());
    }

    @Test
        //请求查询 NFT 详情接口示例
    void TestQueryNft() {
        QueryNftRes res = client.nftClient.queryNft(
                "bakvavoy",
                "avatabpyev9ewlg25bz4v8lpehap5xor");
        System.out.println(res);
    }

    @Test
        //请求查询 NFT 操作记录接口示例
    void TestQueryNftHistory() {
        QueryNftHistoryReq req = new QueryNftHistoryReq();
        req.setLimit("2");
        QueryNftHistoryRes res = client.nftClient.queryNftHistory(
                "bakvavoy",
                "avatabpyev9ewlg25bz4v8lpehap5xor", req);
        System.out.println(res);
    }
}
