package proxy.tx.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import constant.ErrorMessage;
import exception.SdkException;
import model.ErrorResponse;
import model.tx.QueryQueueResponse;
import model.tx.QueryTxResponse;
import proxy.tx.TxProxy;
import util.HttpClient;

public class TxClient implements TxProxy {
    private static final String QUERY_TX = "/v1beta1/tx/";
    private static final String QUERY_QUEUE_INFO = "/v1beta1/tx/queue/info";

    /**
     * Query transaction
     *
     * @param operationId Transaction operationId
     * @return TxRes, Transaction Result
     */
    public QueryTxResponse queryTx(String operationId){
        StringBuffer sb = new StringBuffer();
        sb.append(QUERY_TX);
        sb.append(operationId);
        ForestResponse response = HttpClient.Get(sb.toString(), "");
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryTxResponse res = JSONObject.parseObject(result, QueryTxResponse.class);
        return res;
    }

    /**
     * Query queue info
     *
     * @return QueryQueueResponse, queue info
     */
    public QueryQueueResponse queryQueueInfo(){
        ForestResponse response = HttpClient.Get(QUERY_QUEUE_INFO, "");
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryQueueResponse res = JSONObject.parseObject(result, QueryQueueResponse.class);
        return res;
    }
}
