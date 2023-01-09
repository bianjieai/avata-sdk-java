package proxy.tx;

import model.tx.TxRes;

public interface TxProxy {
    /**
     * 上链交易结果查询
     * @param taskId TASK ID
     * @return
     */
    TxRes queryTx(String taskId);
}
