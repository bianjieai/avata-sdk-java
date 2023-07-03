package evm;

import ai.bianjie.avatasdk.AvataEvmClient;
import ai.bianjie.avatasdk.model.evm.tx.QueryTxRes;
import ai.bianjie.avatasdk.model.evm.tx.QueryTxTypesRes;
import org.junit.jupiter.api.Test;

public class TxTest {
    AvataEvmClient client = new AvataEvmClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();

    @Test
    // 请求上链交易结果查询接口示例
    public void queryTx() {
        QueryTxRes txRes = client.txClient.queryTx("");
        System.out.println(txRes.getData());
    }

    @Test
    // 枚举值列表查询
    public void queryTxTypes() {
        QueryTxTypesRes txRes = client.txClient.queryTxTypes();
        System.out.println(txRes.getData());
    }
}
