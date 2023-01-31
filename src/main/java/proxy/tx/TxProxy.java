package proxy.tx;

import model.tx.QueryQueueResponse;
import model.tx.QueryTxResponse;

public interface TxProxy {
    /**
     * 上链交易结果查询
     *
     * @param operationId OPERATION ID
     * @return
     */
    QueryTxResponse queryTx(String operationId);

    /**
     * 上链交易排队状态查询
     *
     * @return
     */
    QueryQueueResponse queryQueueInfo();
}
