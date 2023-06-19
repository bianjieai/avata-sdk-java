package ai.bianjie.avatasdk.proxy.account.impl;

import ai.bianjie.avatasdk.config.ConfigInfo;
import ai.bianjie.avatasdk.exception.AvataException;
import ai.bianjie.avatasdk.model.account.*;
import ai.bianjie.avatasdk.proxy.account.AccountProxy;
import ai.bianjie.avatasdk.util.HttpClient;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountClient implements AccountProxy {

    private static final String CREATE_ACCOUNT = "/v2/account";// 创建链账户接口
    private static final String BATCH_CREATE_ACCOUNTS = "/v2/accounts";// 批量创建链账户接口
    private static final String QUERY_ACCOUNTS = "/v2/accounts";// 查询链账户接口
    private static final String QUERY_ACCOUNTS_HISTORY = "/v2/accounts/history";// 查询链账户操作记录接口

    private ConfigInfo configInfo;

    public AccountClient(ConfigInfo configInfo) {
        this.configInfo = configInfo;
    }


    @Override
    public CreateAccountRes createAccount(CreateAccountReq req) {
        log.debug("CreateAccountReq {}", req);
        log.debug("createAccount start");
        // check params
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        ForestResponse response = HttpClient.Post(CREATE_ACCOUNT, JSONObject.toJSONString(req), configInfo);
        String result = response.readAsString();
        CreateAccountRes res = JSONObject.parseObject(result, CreateAccountRes.class);
        log.debug("createAccount end");
        return res;
    }

    @Override
    public BatchCreateAccountRes batchCreateAccounts(BatchCreateAccountReq req) {
        log.debug("BatchCreateAccountReq {}", req);
        log.debug("batchCreateAccounts start");
        // check params
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        ForestResponse response = HttpClient.Post(BATCH_CREATE_ACCOUNTS, JSONObject.toJSONString(req), configInfo);
        String result = response.readAsString();
        BatchCreateAccountRes res = JSONObject.parseObject(result, BatchCreateAccountRes.class);
        log.debug("batchCreateAccounts end");
        return res;
    }

    @Override
    public QueryAccountsRes queryAccounts(QueryAccountsReq req) {
        log.debug("QueryAccountsReq {}", req);
        log.debug("queryAccounts start");
        ForestResponse response = HttpClient.Get(QUERY_ACCOUNTS, JSONObject.toJSONString(req), configInfo);
        String result = response.readAsString();
        QueryAccountsRes res = JSONObject.parseObject(result, QueryAccountsRes.class);
        log.debug("queryAccounts end");
        return res;
    }

    @Override
    public QueryAccountsHistoryRes queryAccountsHistory(QueryAccountsHistoryReq req) {
        log.debug("QueryAccountsHistoryReq {}", req);
        log.debug("queryAccountsHistory start");
        ForestResponse response = HttpClient.Get(QUERY_ACCOUNTS_HISTORY, JSONObject.toJSONString(req), configInfo);
        String result = response.readAsString();
        QueryAccountsHistoryRes res = JSONObject.parseObject(result, QueryAccountsHistoryRes.class);
        log.debug("queryAccountsHistory end");
        return res;
    }
}
