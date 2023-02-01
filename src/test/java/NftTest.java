import model.PublicResponse;
import model.nft.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NftTest {
    Client client = new Client.Builder()
            .setDoMain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();

    String OperationID = String.valueOf(System.currentTimeMillis());

    @Test
        //请求创建 NFT 类别接口示例
    void TestCreateClass() {
        CreateClassReq req = new CreateClassReq();
        req.setName("lmhnftclassname01");
        req.setClassId("bakvavoy");
        req.setSymbol("123");
        req.setDescription("123");
        req.setUri("http://www.123.com");
        req.setUriHash("123");
        req.setData("123");
        req.setOwner("iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl");
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "1");
        req.setOperationId(OperationID);
        try {
            PublicResponse res = client.nftClient.createClass(req);
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询 NFT 类别列表接口示例
    void TestQueryClasses() {
        QueryClassesReq req = new QueryClassesReq();
        req.setId("bakvavoy");
        req.setOwner("iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl");
        QueryClassesRes res = client.nftClient.queryClasses(req);
        System.out.println(res.getData());
    }

    @Test
        //请求查询 NFT 类别详情接口示例
    void TestQueryClass() {
        QueryClassRes res = client.nftClient.queryClass("bakvavoy");
        System.out.println(res.getData());
    }

    @Test
        //请求转让 NFT 类别接口示例
    void TestTransferClass() {
        TransferClassReq req = new TransferClassReq();
        req.setRecipient("iaa1jxf58dswgfqs84vw57wzucmttda3s3eu8dhcgr");
        req.setOperationId(OperationID);
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
        CreateNftReq req = new CreateNftReq();
        req.setName("lmhnft023011");
        req.setUri("http://www.456.com");
        req.setUriHash("456");
        req.setData("456");
        req.setRecipient("iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl");
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "2");
        req.setOperationId(OperationID);
        try {
            PublicResponse res = client.nftClient.createNft(req, "bakvavoy");
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求转让 NFT 接口示例
    void TestTransferNft() {
        TransferNftReq req = new TransferNftReq();
        req.setRecipient("iaa1jxf58dswgfqs84vw57wzucmttda3s3eu8dhcgr");
        req.setOperationId(OperationID);
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "3");
        try {
            PublicResponse res = client.nftClient.transferNft(req,
                    "bakvavoy",
                    "iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl",
                    "avatavgj7c3u5722k0oddsgyi3ps2ced");
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求编辑 NFT 接口示例
    void TestEditNft() {
        EditNftReq req = new EditNftReq();
        req.setName("lmhtesteditnft0001");
        req.setUri("http://www.789.com");
        req.setData("789");
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "3");
        req.setOperationId(OperationID);
        try {
            PublicResponse res = client.nftClient.editNft(req,
                    "bakvavoy",
                    "iaa1jxf58dswgfqs84vw57wzucmttda3s3eu8dhcgr",
                    "avatavgj7c3u5722k0oddsgyi3ps2ced");
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求销毁 NFT 接口示例
    void TestDeleteNft() {
        DeleteNftReq req = new DeleteNftReq();
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "4");
        req.setOperationId(OperationID);
        try {
            PublicResponse res = client.nftClient.deleteNft(req,
                    "bakvavoy",
                    "iaa1jxf58dswgfqs84vw57wzucmttda3s3eu8dhcgr",
                    "avatavgj7c3u5722k0oddsgyi3ps2ced");
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求批量发行 NFT 接口示例
    void TestBatchCreateNft() {
        BatchCreateNftReq req = new BatchCreateNftReq();
        req.setName("lmhbatchnft111");
        req.setUri("http://www.000.com");
        req.setUriHash("000");
        req.setData("000");
        List<BatchCreateNftReq.RecipientsDTO> list = new ArrayList<>();
        BatchCreateNftReq.RecipientsDTO dto1 = new BatchCreateNftReq.RecipientsDTO();
        dto1.setAmount(2);
        dto1.setRecipient("iaa1jxf58dswgfqs84vw57wzucmttda3s3eu8dhcgr");
//        BatchCreateNftReq.RecipientsDTO dto2 = new BatchCreateNftReq.RecipientsDTO();
//        dto2.setAmount(2);
//        dto2.setRecipient("iaa19lv0jz60plu6dd9kzycsp8l86ap4gmaynwxd9d");
        list.add(dto1);
//        list.add(dto2);
        req.setRecipients(list);
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "0");
        req.setOperationId(OperationID);
        try {
            PublicResponse res = client.nftClient.batchCreateNft(req, "bakvavoy");
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求批量转让 NFT 接口示例
    void TestBatchTransferNft() {
        BatchTransferNftReq req = new BatchTransferNftReq();
        List<BatchTransferNftReq.DataDTO> datalist = new ArrayList<>();
        BatchTransferNftReq.DataDTO dataDTO = new BatchTransferNftReq.DataDTO();
        List<BatchTransferNftReq.DataDTO.NftsDTO> nftlist = new ArrayList<>();
        BatchTransferNftReq.DataDTO.NftsDTO nftsDTO = new BatchTransferNftReq.DataDTO.NftsDTO();
        dataDTO.setNfts(nftlist);
        dataDTO.setRecipient("iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl");
        nftsDTO.setClassId("bakvavoy");
        nftsDTO.setNftId("avataaeqov8gmo0xetsexyi7k7cvxngn");
        datalist.add(dataDTO);
        nftlist.add(nftsDTO);
        req.setData(datalist);
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "9");
        req.setOperationId(OperationID);
        try {
            PublicResponse res = client.nftClient.batchTransferNft(req, "iaa1jxf58dswgfqs84vw57wzucmttda3s3eu8dhcgr");
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求批量编辑 NFT 接口示例
    void TestBatchEditNft() {
        BatchEditNftReq req = new BatchEditNftReq();
        List<BatchEditNftReq.NftsDTO> nftslist = new ArrayList<>();
        BatchEditNftReq.NftsDTO nftsDTO = new BatchEditNftReq.NftsDTO();
        nftsDTO.setClassId("bakvavoy");
        nftsDTO.setNftId("avataaeqov8gmo0xetsexyi7k7cvxngn");
        nftsDTO.setName("lmheditnftssss");
        nftsDTO.setUri("http://www.hasbocai.com");
        nftsDTO.setData("123");
        nftslist.add(nftsDTO);
        req.setNfts(nftslist);
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "6");
        req.setOperationId(OperationID);
        try {
            PublicResponse res = client.nftClient.batchEditNft(req, "iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl");
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }

    @Test
        //请求批量销毁 NFT 接口示例
    void TestBatchDeleteNft() {
        BatchDeleteNftReq req = new BatchDeleteNftReq();
        List<BatchDeleteNftReq.NftsDTO> nftslist = new ArrayList<>();
        BatchDeleteNftReq.NftsDTO nftsDTO = new BatchDeleteNftReq.NftsDTO();
        nftsDTO.setClassId("bakvavoy");
        nftsDTO.setNftId("avataaeqov8gmo0xetsexyi7k7cvxngn");
        nftslist.add(nftsDTO);
        req.setNfts(nftslist);
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("123456", "23");
        req.setOperationId(OperationID);
        try {
            PublicResponse res = client.nftClient.batchDeleteNft(req, "iaa14c3dul0xdh4javrxec5vvfzvy7qk0qnfrruvvl");
            System.out.println(res.getData().getOperationId());
            System.out.println("no exception");
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
        QueryNftHistoryRes res = client.nftClient.queryNftHistory(
                "bakvavoy",
                "avatabpyev9ewlg25bz4v8lpehap5xor");
        System.out.println(res);
    }
}
