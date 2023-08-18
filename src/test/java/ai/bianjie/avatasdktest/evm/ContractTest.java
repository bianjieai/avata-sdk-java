package ai.bianjie.avatasdktest.evm;

import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.evm.contract.ContractCallReq;
import ai.bianjie.avatasdk.model.evm.contract.QueryContractCallReq;
import ai.bianjie.avatasdk.model.evm.contract.QueryContractCallRes;
import org.junit.jupiter.api.Test;
import ai.bianjie.avatasdktest.AvataClientTest;

public class ContractTest{

    @Test
        //请求调用合约接口示例
    void TestContractCall() {
        ContractCallReq req = new ContractCallReq();
        req.setFrom(""); // 域名拥有者地址
        req.setTo(""); // 解析器合约地址
        req.setData("");
        req.setGasLimit(400000);
        req.setEstimation(1);
        req.setOperationId("");
        try {
            PublicResponse res = AvataClientTest.getAvataClient().evmClient.contractClient.contractCall(req);
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
            QueryContractCallRes res = AvataClientTest.getAvataClient().evmClient.contractClient.queryContractCall(req);
            System.out.println(res.getData());
            System.out.println("no ai.bianjie.avatasdk.exception");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}