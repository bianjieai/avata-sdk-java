package proxy.tx.impl;

import com.alibaba.fastjson.JSONObject;
import constant.ErrorMessage;
import exception.SdkException;
import model.tx.TxRes;
import okhttp3.Response;
import proxy.tx.TxProxy;
import util.HttpReq;

import java.io.IOException;

public class TxClient implements TxProxy {

    /**
     * Query transaction
     *
     * @param operationId Transaction operationId
     * @return TxRes, Transaction Result
     */
    public TxRes queryTx(String operationId){
        HttpReq httpReq = new HttpReq();
        // todo 使用stringbuffer
        String content = "/tx/" + operationId;
        Response res = httpReq.Get(content);
        String tx;
        try {
            tx = res.body().string();
        } catch (IOException e) {
            // todo 定义错误类型
            throw new SdkException(ErrorMessage.UNKNOWN_ERROR);
        }
        TxRes txRes = JSONObject.parseObject(tx, TxRes.class);
        return txRes;
    }
}
