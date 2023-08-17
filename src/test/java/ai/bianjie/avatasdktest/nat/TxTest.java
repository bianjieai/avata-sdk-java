package ai.bianjie.avatasdktest.nat;

import ai.bianjie.avatasdk.model.nat.tx.QueryTxRes;
import ai.bianjie.avatasdk.model.nat.tx.QueryTxTypesRes;
import ai.bianjie.avatasdktest.AvataClientTest;
import org.junit.jupiter.api.Test;

public class TxTest {

    @Test
    // 请求上链交易结果查询接口示例
    public void queryTx() {
        QueryTxRes txRes = AvataClientTest.getAvataClient().nativeClient.txClient.queryTx("");
        System.out.println(txRes.getData());
    }

    @Test
    // 枚举值列表查询
    public void queryTxTypes() {
        QueryTxTypesRes txRes = AvataClientTest.getAvataClient().nativeClient.txClient.queryTxTypes();
        System.out.println(txRes.getData());
    }
}
