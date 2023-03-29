package ai.bianjie.avatasdk.proxy.tx;

import ai.bianjie.avatasdk.model.tx.QueryTxRes;

public interface TxProxy {
    /**
     * 上链交易结果查询
     *
     * @param operationId OPERATION ID
     * @return QueryTxRes
     */
    QueryTxRes queryTx(String operationId);

}
