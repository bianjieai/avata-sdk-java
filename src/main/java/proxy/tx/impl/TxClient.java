package proxy.tx.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import constant.ErrorMessage;
import exception.SdkException;
import model.BaseResponse;
import model.ErrorResponse;
import model.tx.QueryQueueResponse;
import model.tx.QueryTxResponse;
import proxy.tx.TxProxy;
import util.HttpClient;

public class TxClient implements TxProxy {
    private static final String QUERY_TX = "/v1beta1/tx/%s";
    private static final String QUERY_QUEUE_INFO = "/v1beta1/tx/queue/info";

    @Override
    public QueryTxResponse queryTx(String operationId) {
        String path = String.format(QUERY_TX, operationId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryTxResponse res = JSONObject.parseObject(result, QueryTxResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryQueueResponse queryQueueInfo() {
        ForestResponse response = HttpClient.Get(QUERY_QUEUE_INFO, "");
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryQueueResponse res = JSONObject.parseObject(result, QueryQueueResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }
}
