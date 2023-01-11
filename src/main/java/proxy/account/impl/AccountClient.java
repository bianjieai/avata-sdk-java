package proxy.account.impl;

import com.alibaba.fastjson.JSONObject;
import constant.ErrorMessage;
import exception.SdkException;
import model.ErrorResponse;
import model.account.*;
import model.tx.QueryTxResponse;
import okhttp3.Response;
import proxy.account.AccountProxy;
import util.HttpClient;
import util.Strings;

public class AccountClient implements AccountProxy {
    private static final String CREATE_ACCOUNT = "/v1beta1/account";
    private static final String BATCH_CREATE_ACCOUNTS = "/v1beta1/accounts";
    private static final String QUERY_ACCOUNTS = "/v1beta1/accounts";
    private static final String QUERY_ACCOUNTS_HISTORY = "/v1beta1/accounts/history";

    public CreateAccountRes createAccount(CreateAccountReq req){
        // check params
        if (Strings.isEmpty(req.getName())) {
            throw new SdkException(ErrorMessage.NAME_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String result;
        Response res;
        try {
            res = HttpClient.Post(CREATE_ACCOUNT, JSONObject.toJSONString(req));
            result = res.body().string();
        }catch (Exception e) {
            throw  new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);
        }
        if (res.code() != 200){
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(res.code(), res.message()));
        }
        CreateAccountRes response = JSONObject.parseObject(result, CreateAccountRes.class);
        response.setCode(0);
        response.setMessage("");
        return response;
    }

    @Override
    public BatchCreateAccountRes batchCreateAccounts(BatchCreateAccountReq req) {
        // check params
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String result;
        Response res;
        try {
            res = HttpClient.Post(BATCH_CREATE_ACCOUNTS, JSONObject.toJSONString(req));
            result = res.body().string();
        }catch (Exception e) {
            throw  new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);
        }
        if (res.code() != 200){
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(res.code(), res.message()));
        }
        BatchCreateAccountRes response = JSONObject.parseObject(result, BatchCreateAccountRes.class);
        response.setCode(0);
        response.setMessage("");
        return response;
    }

    @Override
    public QueryAccountsRes queryAccounts(QueryAccountsReq req) {
        StringBuffer sb = new StringBuffer();
        sb.append("?");
        //todo 参数拼接方法
        String result;
        Response res;
        try {
            res = HttpClient.Get(QUERY_ACCOUNTS, sb.toString());
            result = res.body().string();
        } catch (Exception e) {
            throw new SdkException(ErrorMessage.UNKNOWN_ERROR, null, null);
        }
        if (res.code() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(res.code(), res.message()));
        }
        QueryAccountsRes txRes = JSONObject.parseObject(result, QueryAccountsRes.class);
        txRes.setCode(res.code());
        txRes.setMessage(res.message());
        return txRes;
    }

    @Override
    public QueryAccountsHistoryRes queryAccountsHistory(QueryAccountsHistoryReq req) {
        StringBuffer sb = new StringBuffer();
        sb.append("?");
        //todo 参数拼接方法
        String result;
        Response res;
        try {
            res = HttpClient.Get(QUERY_ACCOUNTS_HISTORY, sb.toString());
            result = res.body().string();
        } catch (Exception e) {
            throw new SdkException(ErrorMessage.UNKNOWN_ERROR, null, null);
        }
        if (res.code() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(res.code(), res.message()));
        }
        QueryAccountsHistoryRes txRes = JSONObject.parseObject(result, QueryAccountsHistoryRes.class);
        txRes.setCode(res.code());
        txRes.setMessage(res.message());
        return txRes;
    }
}
