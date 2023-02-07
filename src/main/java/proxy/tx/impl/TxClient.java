package proxy.tx.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import constant.ErrorMessage;
import exception.AvataException;
import model.BaseResponse;
import model.ErrorResponse;
import model.tx.QueryQueueReq;
import model.tx.QueryQueueRes;
import model.tx.QueryTxRes;
import proxy.tx.TxProxy;
import util.HttpClient;

public class TxClient implements TxProxy {
    private static final String QUERY_TX = "/v1beta1/tx/%s";
    private static final String QUERY_QUEUE_INFO = "/v1beta1/tx/queue/info";

    @Override
    public QueryTxRes queryTx(String operationId) {
        String path = String.format(QUERY_TX, operationId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryTxRes res = JSONObject.parseObject(result, QueryTxRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryQueueRes queryQueueInfo(QueryQueueReq req) {
        ForestResponse response = HttpClient.Get(QUERY_QUEUE_INFO, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryQueueRes res = JSONObject.parseObject(result, QueryQueueRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }
}
