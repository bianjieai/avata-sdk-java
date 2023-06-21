package ai.bianjie.avatasdk.proxy.evm.tx;

import ai.bianjie.avatasdk.model.QueryTxTypesRes;
import ai.bianjie.avatasdk.model.evm.tx.QueryTxRes;


public interface TxProxy {
    /**
     * 上链交易结果查询
     *
     * @param operationId OPERATION ID
     * @return QueryTxRes
     */
    QueryTxRes queryTx(String operationId);


    /**
     * EVM 枚举值列表查询
     *
     * @return QueryTxTypesRes
     */

    QueryTxTypesRes queryTxTypes();

}
