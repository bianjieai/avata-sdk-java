package proxy.account.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import constant.ErrorMessage;
import exception.AvataException;
import model.BaseResponse;
import model.ErrorResponse;
import model.account.*;
import proxy.account.AccountProxy;
import util.HttpClient;
import com.dtflys.forest.utils.StringUtils;

public class AccountClient implements AccountProxy {
    private static final String CREATE_ACCOUNT = "/v1beta1/account";
    private static final String BATCH_CREATE_ACCOUNTS = "/v1beta1/accounts";
    private static final String QUERY_ACCOUNTS = "/v1beta1/accounts";
    private static final String QUERY_ACCOUNTS_HISTORY = "/v1beta1/accounts/history";

    @Override
    public CreateAccountRes createAccount(CreateAccountReq req) {
        // check params
        if (StringUtils.isEmpty(req.getName())) {
            throw new AvataException(ErrorMessage.NAME_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw new AvataException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        ForestResponse response = HttpClient.Post(CREATE_ACCOUNT, JSONObject.toJSONString(req));

        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }// todo 挪到validateResponse里
        CreateAccountRes res = JSONObject.parseObject(result, CreateAccountRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public BatchCreateAccountRes batchCreateAccounts(BatchCreateAccountReq req) {
        // check params
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw new AvataException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        ForestResponse response = HttpClient.Post(BATCH_CREATE_ACCOUNTS, JSONObject.toJSONString(req));

        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        BatchCreateAccountRes res = JSONObject.parseObject(result, BatchCreateAccountRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryAccountsRes queryAccounts(QueryAccountsReq req) {
        ForestResponse response = HttpClient.Get(QUERY_ACCOUNTS, JSONObject.toJSONString(req));

        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryAccountsRes res = JSONObject.parseObject(result, QueryAccountsRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryAccountsHistoryRes queryAccountsHistory(QueryAccountsHistoryReq req) {
        ForestResponse response = HttpClient.Get(QUERY_ACCOUNTS_HISTORY, JSONObject.toJSONString(req));

        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryAccountsHistoryRes res = JSONObject.parseObject(result, QueryAccountsHistoryRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }
}
