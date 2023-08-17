package ai.bianjie.avatasdktest.evm;

import ai.bianjie.avatasdk.model.evm.tx.QueryTxRes;
import ai.bianjie.avatasdk.model.evm.tx.QueryTxTypesRes;
import ai.bianjie.avatasdktest.AvataClientTest;
import org.junit.jupiter.api.Test;

public class TxTest {


    @Test
    // 请求上链交易结果查询接口示例
    public void queryTx() {
        QueryTxRes txRes = AvataClientTest.getAvataClient().evmClient.txClient.queryTx("createnftclass1692091957018");
        System.out.println(txRes.getData());
    }

    @Test
    // 枚举值列表查询
    public void queryTxTypes() {
        QueryTxTypesRes txRes = AvataClientTest.getAvataClient().evmClient.txClient.queryTxTypes();
        System.out.println(txRes.getData());
    }
}
