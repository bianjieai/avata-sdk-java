import model.PublicResponse;
import model.account.CreateAccountReq;
import model.account.CreateAccountRes;
import model.account.QueryAccountsReq;
import model.account.QueryAccountsRes;
import model.records.CreateRecordReq;
import org.junit.jupiter.api.Test;

public class RecordTest {
    Client client = new Client.Builder()
            .setDoMain("")
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
        req.setIdentityName("和水果都啊");
        req.setIdentityNum("372522196912162618");
        req.setType(1);
        req.setName("ahscyu");
        req.setDescription("wefwas");
        req.setName("dwcwa");
        req.setHash("weqdfcac");
        req.setHashType(1);
        req.setOperationId(OperationID);
        try {
            PublicResponse res = client.recordsClient.createRecord(req);
            System.out.println(res.getData());
            System.out.println("no exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}