package ai.bianjie.avatasdk.proxy.tx;

import ai.bianjie.avatasdk.model.tx.QueryQueueReq;
import ai.bianjie.avatasdk.model.tx.QueryQueueRes;
import ai.bianjie.avatasdk.model.tx.QueryTxRes;

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
