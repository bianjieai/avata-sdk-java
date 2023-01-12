package proxy.account.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import constant.ErrorMessage;
import exception.SdkException;
import model.ErrorResponse;
import model.account.*;
import model.tx.QueryQueueResponse;
import model.tx.QueryTxResponse;
import okhttp3.Response;
import proxy.account.AccountProxy;
import util.HttpClient;
import util.Strings;

import java.util.Map;

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
        ForestResponse response = HttpClient.Post(CREATE_ACCOUNT, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        CreateAccountRes res = JSONObject.parseObject(result, CreateAccountRes.class);
        res.setCode(response.getStatusCode());
        res.setMessage(response.getReasonPhrase());
        return res;
    }

    @Override
    public BatchCreateAccountRes batchCreateAccounts(BatchCreateAccountReq req) {
        // check params
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        ForestResponse response = HttpClient.Post(BATCH_CREATE_ACCOUNTS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        BatchCreateAccountRes res = JSONObject.parseObject(result, BatchCreateAccountRes.class);
        res.setCode(response.getStatusCode());
        res.setMessage(response.getReasonPhrase());
        return res;
    }

    @Override
    public QueryAccountsRes queryAccounts(QueryAccountsReq req) {
        ForestResponse response = HttpClient.Get(QUERY_ACCOUNTS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryAccountsRes res = JSONObject.parseObject(result, QueryAccountsRes.class);
        return res;
    }

    @Override
    public QueryAccountsHistoryRes queryAccountsHistory(QueryAccountsHistoryReq req) {
        ForestResponse response = HttpClient.Get(QUERY_ACCOUNTS_HISTORY, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryAccountsHistoryRes res = JSONObject.parseObject(result, QueryAccountsHistoryRes.class);
        return res;
    }
}
