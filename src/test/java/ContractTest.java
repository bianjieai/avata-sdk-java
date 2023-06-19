import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.contract.ContractCallReq;
import ai.bianjie.avatasdk.model.contract.QueryContractCallReq;
import ai.bianjie.avatasdk.model.contract.QueryContractCallRes;
import org.junit.jupiter.api.Test;


public class ContractTest {
    AvataClient client = new AvataClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();

    String OperationID = String.valueOf(System.currentTimeMillis());

    @Test
        //请求调用合约接口示例
    void TestContractCall() {
        ContractCallReq req = new ContractCallReq();
        req.setFrom(""); // 域名拥有者地址
        req.setTo(""); // 解析器合约地址
        req.setData("");
        req.setGasLimit(400000);
        req.setEstimation(1);
        req.setOperationId("contract" + OperationID);
        try {
            PublicResponse res = client.contractClient.contractCall(req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
        //请求查询合约接口示例
    void TestQueryContractCall() {
        QueryContractCallReq req = new QueryContractCallReq();
        req.setData("");
        req.setTo("");
        try {
            QueryContractCallRes res = client.contractClient.queryContractCall(req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}