package evm;

import ai.bianjie.avatasdk.AvataEvmClient;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.evm.contract.ContractCallReq;
import ai.bianjie.avatasdk.model.evm.contract.QueryContractCallReq;
import ai.bianjie.avatasdk.model.evm.contract.QueryContractCallRes;
import org.junit.jupiter.api.Test;


public class ContractTest {
    AvataEvmClient client = new AvataEvmClient.Builder()
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
        req.setFrom("0x1bBC0Cf1C37d34aFc9FF2d18161EA7cFe3839fD1"); // 域名拥有者地址
        req.setTo("0xc2B8C8849A02E8D98BE114c128aab536B4E98b62"); // 解析器合约地址
        req.setData("0x8b95dd719ebafa531cb3627702260ea6660c6d6bec9b61e825477c1d4b304bac1372319300000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000060000000000000000000000000000000000000000000000000000000000000002a30786332423843383834394130324538443938424531313463313238616162353336423445393862363200000000000000000000000000000000000000000000");
        req.setGasLimit(400000);
        req.setEstimation(1);
        req.setOperationId("contract" + OperationID);// contract1682649688154
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
        req.setData("0xf1cb7e069ebafa531cb3627702260ea6660c6d6bec9b61e825477c1d4b304bac137231930000000000000000000000000000000000000000000000000000000000000001");
        req.setTo("0xc2B8C8849A02E8D98BE114c128aab536B4E98b62");
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