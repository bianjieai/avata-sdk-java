package nat;

import ai.bianjie.avatasdk.AvataNativeClient;
import ai.bianjie.avatasdk.model.nat.tx.QueryTxRes;
import ai.bianjie.avatasdk.model.nat.tx.QueryTxTypesRes;
import org.junit.jupiter.api.Test;

public class TxTest {
    AvataNativeClient client = new AvataNativeClient.Builder()
            .setDomain("")
            .setApiKey("")
            .setApiSecret("")
            .init();

    @Test
    // 请求上链交易结果查询接口示例
    public void queryTx() {
        QueryTxRes txRes = client.txClient.queryTx("");
        System.out.println(txRes.getData());
    }
    @Test
    public void queryTxTypes(){
        QueryTxTypesRes txRes = client.txClient.queryTxTypes();
        System.out.println(txRes.getData());
    }
}
