package proxy.account.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import exception.AvataException;
import lombok.extern.slf4j.Slf4j;
import model.account.*;
import proxy.account.AccountProxy;
import util.HttpClient;
import com.dtflys.forest.utils.StringUtils;

@Slf4j
public class AccountClient implements AccountProxy {
    private static final String CREATE_ACCOUNT = "/v1beta1/account";
    private static final String BATCH_CREATE_ACCOUNTS = "/v1beta1/accounts";
    private static final String QUERY_ACCOUNTS = "/v1beta1/accounts";
    private static final String QUERY_ACCOUNTS_HISTORY = "/v1beta1/accounts/history";

    @Override
    public CreateAccountRes createAccount(CreateAccountReq req) {
        log.debug("CreateAccountReq {}", req);
        log.info("createAccount start");
        // check params
        if (StringUtils.isEmpty(req.getName())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "name"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        ForestResponse response = HttpClient.Post(CREATE_ACCOUNT, JSONObject.toJSONString(req));

        String result = response.readAsString();
        CreateAccountRes res = JSONObject.parseObject(result, CreateAccountRes.class);
        
        log.info("createAccount end");
        return res;
    }

    @Override
    public BatchCreateAccountRes batchCreateAccounts(BatchCreateAccountReq req) {
        log.debug("BatchCreateAccountReq {}", req);
        log.info("batchCreateAccounts start");
        // check params
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        ForestResponse response = HttpClient.Post(BATCH_CREATE_ACCOUNTS, JSONObject.toJSONString(req));

        String result = response.readAsString();
        
        BatchCreateAccountRes res = JSONObject.parseObject(result, BatchCreateAccountRes.class);
        
        log.info("batchCreateAccounts end");
        return res;
    }

    @Override
    public QueryAccountsRes queryAccounts(QueryAccountsReq req) {
        log.debug("QueryAccountsReq {}", req);
        log.info("queryAccounts start");
        ForestResponse response = HttpClient.Get(QUERY_ACCOUNTS, JSONObject.toJSONString(req));

        String result = response.readAsString();
        
        QueryAccountsRes res = JSONObject.parseObject(result, QueryAccountsRes.class);
        
        log.info("queryAccounts end");
        return res;
    }

    @Override
    public QueryAccountsHistoryRes queryAccountsHistory(QueryAccountsHistoryReq req) {
        log.debug("QueryAccountsHistoryReq {}", req);
        log.info("queryAccountsHistory start");
        ForestResponse response = HttpClient.Get(QUERY_ACCOUNTS_HISTORY, JSONObject.toJSONString(req));

        String result = response.readAsString();
        
        QueryAccountsHistoryRes res = JSONObject.parseObject(result, QueryAccountsHistoryRes.class);
        
        log.info("queryAccountsHistory end");
        return res;
    }
}
