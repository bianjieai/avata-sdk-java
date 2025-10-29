package ai.bianjie.avatasdk.proxy.nat.tx.impl;


import ai.bianjie.avatasdk.model.nat.tx.QueryTxRes;
import ai.bianjie.avatasdk.model.nat.tx.QueryTxTypesRes;
import ai.bianjie.avatasdk.proxy.nat.tx.TxProxy;
import ai.bianjie.avatasdk.util.HttpClient;
import com.alibaba.fastjson2.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tx implements TxProxy {

    private static final String QUERY_TX = "/v3/native/tx/%s"; // 原生上链交易结果查询
    private static final String QUERY_TX_TYPES = "/v3/native/dict/tx_types"; // 原生枚举值列表查询

    private HttpClient httpClient;

    public Tx(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    @Override
    public QueryTxRes queryTx(String operationId) {
        log.debug("operationId {}", operationId);
        log.debug("queryTx start");
        String path = String.format(QUERY_TX, operationId);
        ForestResponse response = httpClient.get(path, "");
        String result = response.readAsString();
        QueryTxRes res = JSONObject.parseObject(result, QueryTxRes.class);
        log.debug("queryTx end");
        return res;
    }


    @Override
    public QueryTxTypesRes queryTxTypes(){
        log.debug("queryTxTypes start");
        ForestResponse response = httpClient.get(QUERY_TX_TYPES, "");
        String result = response.readAsString();
        QueryTxTypesRes res = JSONObject.parseObject(result, QueryTxTypesRes.class);
        log.debug("queryTxTypes end");
        return res;
    }

}
