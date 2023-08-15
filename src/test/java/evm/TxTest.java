package evm;

import ai.bianjie.avatasdk.AvataClient;
import ai.bianjie.avatasdk.model.evm.tx.QueryTxRes;
import ai.bianjie.avatasdk.model.evm.tx.QueryTxTypesRes;
import org.junit.jupiter.api.Test;

public class TxTest {
    AvataClient client = new AvataClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .setHttpTimeout(10000)
            .init();

    @Test
    // 请求上链交易结果查询接口示例
    public void queryTx() {
        QueryTxRes txRes = client.evmClient.txClient.queryTx("createnftclass1692091957018");
        System.out.println(txRes.getData());
    }

    @Test
    // 枚举值列表查询
    public void queryTxTypes() {
        QueryTxTypesRes txRes = client.evmClient.txClient.queryTxTypes();
        System.out.println(txRes.getData());
    }
}
