package ai.bianjie.avatasdk.proxy.evm.tx.impl;

import ai.bianjie.avatasdk.config.ConfigInfo;
import ai.bianjie.avatasdk.model.evm.tx.QueryTxRes;
import ai.bianjie.avatasdk.model.evm.tx.QueryTxTypesRes;
import ai.bianjie.avatasdk.proxy.evm.tx.TxProxy;
import ai.bianjie.avatasdk.util.HttpClient;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TxClient implements TxProxy {

    private static final String QUERY_TX = "/v3/evm/tx/%s"; // EVM 上链交易结果查询
    private static final String QUERY_TX_TYPES = "/v3/evm/dict/tx_types"; // EVM 枚举值列表查询

    private ConfigInfo configInfo;

    public TxClient(ConfigInfo configInfo) {
        this.configInfo = configInfo;
    }

    @Override
    public QueryTxRes queryTx(String operationId) {
        log.debug("operationId {}", operationId);
        log.debug("queryTx start");
        String path = String.format(QUERY_TX, operationId);
        ForestResponse response = HttpClient.Get(path, "", configInfo);
        String result = response.readAsString();
        QueryTxRes res = JSONObject.parseObject(result, QueryTxRes.class);
        log.debug("queryTx end");
        return res;
    }


    @Override
    public QueryTxTypesRes queryTxTypes(){
        log.debug("queryTxTypes start");
        ForestResponse response = HttpClient.Get(QUERY_TX_TYPES, "", configInfo);
        String result = response.readAsString();
        QueryTxTypesRes res = JSONObject.parseObject(result, QueryTxTypesRes.class);
        log.debug("queryTxTypes end");
        return res;
    }

}
