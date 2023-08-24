package ai.bianjie.avatasdktest.nat;

import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.nat.records.CreateRecordReq;
import ai.bianjie.avatasdktest.AvataClientTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecordsTest {
    private AvataClient client;

    @BeforeEach
    public void init() {
        client = AvataClientTest.getAvataClient();
    }
    @Test
        // 请求创建数字作品存证接口示例
    void TestCreateRecord() {
        CreateRecordReq req = new CreateRecordReq();
        req.setIdentityType(1);
        req.setIdentityName("");
        req.setIdentityNum("");
        req.setType(1);
        req.setDescription("");
        req.setName("");
        req.setHash("");
        req.setHashType(1);
        req.setOperationId("createrecord");
        try {
            PublicResponse res = client.nativeClient.recordsClient.createRecord(req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
