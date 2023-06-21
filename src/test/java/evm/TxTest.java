package evm;

import ai.bianjie.avatasdk.AvataEvmClient;
import ai.bianjie.avatasdk.model.evm.tx.QueryTxRes;
import org.junit.jupiter.api.Test;

public class TxTest {
    AvataEvmClient client = new AvataEvmClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .init();

    @Test
    // 请求上链交易结果查询接口示例
    public void queryTx() {
        QueryTxRes txRes = client.txClient.queryTx("1685080230841");
        System.out.println(txRes.getData());
    }

}
