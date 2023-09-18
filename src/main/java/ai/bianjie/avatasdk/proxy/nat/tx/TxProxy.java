package ai.bianjie.avatasdk.proxy.nat.tx;

import ai.bianjie.avatasdk.model.nat.tx.QueryTxRes;
import ai.bianjie.avatasdk.model.nat.tx.QueryTxTypesRes;


public interface TxProxy {
    /**
     * 上链交易结果查询
     *
     * @param operationId OPERATION ID
     * @return QueryTxRes
     */
    QueryTxRes queryTx(String operationId);


    /**
     * 原生枚举值列表查询
     *
     * @return QueryTxTypesRes
     */

    QueryTxTypesRes queryTxTypes();

}
