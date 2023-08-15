package nat;

import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.nat.records.CreateRecordReq;
import org.junit.jupiter.api.Test;

public class RecordsTest {
    AvataClient client = new AvataClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();
    String OperationID = String.valueOf(System.currentTimeMillis());

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
        req.setOperationId("createrecord" + OperationID);
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
