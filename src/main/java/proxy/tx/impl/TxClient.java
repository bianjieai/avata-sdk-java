package proxy.tx.impl;

import com.alibaba.fastjson.JSONObject;
import constant.ErrorMessage;
import exception.SdkException;
import model.tx.QueryTxResponse;
import okhttp3.Response;
import proxy.tx.TxProxy;
import util.HttpClient;

public class TxClient implements TxProxy {
    private static final String QUERY_TX = "/v1beta1/tx/";

    /**
     * Query transaction
     *
     * @param operationId Transaction operationId
     * @return TxRes, Transaction Result
     */
    public QueryTxResponse queryTx(String operationId){
        // todo 优化 httpreq 获取
        HttpClient httpReq = new HttpClient();
        StringBuffer sb = new StringBuffer();
        sb.append(QUERY_TX);
        sb.append(operationId);
        String result;
        Response res;
        try {
            res = httpReq.Get(sb.toString(), "");
            result = res.body().string();
        } catch (Exception e) {
            // todo 定义错误类型
            throw new SdkException(ErrorMessage.UNKNOWN_ERROR);
        }
        if (res.code() != 200) {
            System.out.println("-------");
            throw new SdkException(res.code(), res.message(), null);
        }
        QueryTxResponse txRes = JSONObject.parseObject(result, QueryTxResponse.class);
        txRes.setCode(res.code());
        txRes.setMessage(res.message());
        return txRes;
    }
}
