package proxy.tx;

import model.tx.QueryQueueReq;
import model.tx.QueryQueueRes;
import model.tx.QueryTxRes;

public interface TxProxy {
    /**
     * 上链交易结果查询
     *
     * @param operationId OPERATION ID
     * @return
     */
    QueryTxRes queryTx(String operationId);

    /**
     * 上链交易排队状态查询
     *
     * @return
     */
    QueryQueueRes queryQueueInfo(QueryQueueReq req);
}
