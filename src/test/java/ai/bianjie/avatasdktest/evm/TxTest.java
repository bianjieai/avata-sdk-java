package ai.bianjie.avatasdktest.evm;

import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.evm.tx.QueryTxRes;
import ai.bianjie.avatasdk.model.evm.tx.QueryTxTypesRes;
import ai.bianjie.avatasdktest.AvataClientTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TxTest {

    private AvataClient client;

    @BeforeEach
    public void init() {
        client = AvataClientTest.getAvataClient();
    }
    @Test
    // 请求上链交易结果查询接口示例
    public void queryTx() {
        QueryTxRes txRes = client.evm.tx.queryTx("");
        System.out.println(txRes.getData());
    }

    @Test
    // 枚举值列表查询
    public void queryTxTypes() {
        QueryTxTypesRes txRes = client.evm.tx.queryTxTypes();
        System.out.println(txRes.getData());
    }
}
