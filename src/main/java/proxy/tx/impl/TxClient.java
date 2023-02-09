package proxy.tx.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import lombok.extern.slf4j.Slf4j;
import model.BaseResponse;
import model.tx.QueryQueueReq;
import model.tx.QueryQueueRes;
import model.tx.QueryTxRes;
import proxy.tx.TxProxy;
import util.HttpClient;

@Slf4j
public class TxClient implements TxProxy {
    private static final String QUERY_TX = "/v1beta1/tx/%s";
    private static final String QUERY_QUEUE_INFO = "/v1beta1/tx/queue/info";

    @Override
    public QueryTxRes queryTx(String operationId) {
        log.debug("operationId {}", operationId);
        log.info("queryTx start");
        String path = String.format(QUERY_TX, operationId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();

        QueryTxRes res = JSONObject.parseObject(result, QueryTxRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("queryTx end");
        return res;
    }

    @Override
    public QueryQueueRes queryQueueInfo(QueryQueueReq req) {
        log.debug("QueryQueueReq {}", req);
        log.info("queryQueueInfo start");
        ForestResponse response = HttpClient.Get(QUERY_QUEUE_INFO, JSONObject.toJSONString(req));
        String result = response.readAsString();

        QueryQueueRes res = JSONObject.parseObject(result, QueryQueueRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("queryQueueInfo end");
        return res;
    }
}
