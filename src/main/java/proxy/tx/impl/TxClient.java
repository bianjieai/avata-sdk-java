package proxy.tx.impl;

import com.alibaba.fastjson.JSONObject;
import constant.ErrorMessage;
import exception.SdkException;
import model.tx.TxRes;
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
    public TxRes queryTx(String operationId){
        // todo 优化httpreq获取
        HttpClient httpReq = new HttpClient();
        StringBuffer sb = new StringBuffer();
        sb.append(QUERY_TX);
        sb.append(operationId);
        String result;
        try {
            Response res = httpReq.Get(sb.toString(), "");
            result = res.body().string();
        } catch (Exception e) {
            // todo 定义错误类型
            throw new SdkException(ErrorMessage.UNKNOWN_ERROR);
        }
        TxRes txRes = JSONObject.parseObject(result, TxRes.class);
        return txRes;
    }
}
