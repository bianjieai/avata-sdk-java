package ai.bianjie.avatasdk.proxy.account.impl;

import ai.bianjie.avatasdk.exception.AvataException;
import ai.bianjie.avatasdk.model.account.*;
import ai.bianjie.avatasdk.proxy.account.AccountProxy;
import ai.bianjie.avatasdk.util.HttpClient;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Account implements AccountProxy {

    private static final String CREATE_ACCOUNT = "/v3/account";// 创建链账户接口
    private static final String BATCH_CREATE_ACCOUNTS = "/v3/accounts";// 批量创建链账户接口
    private static final String QUERY_ACCOUNTS = "/v3/accounts";// 查询链账户接口
    private static final String QUERY_NATIVE_ACCOUNTS_HISTORY = "/v3/native/accounts/history";// 原生模块查询链账户操作记录接口
    private static final String QUERY_EVM_ACCOUNTS_HISTORY = "/v3/evm/accounts/history";// EVM 模块查询链账户操作记录接口
    private HttpClient httpClient;

    public Account(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public CreateAccountRes createAccount(CreateAccountReq req) {
        log.debug("CreateAccountReq {}", req);
        log.debug("createAccount start");
        // check params
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        ForestResponse response = httpClient.post(CREATE_ACCOUNT, JSONObject.toJSONString(req));
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
        ForestResponse response = httpClient.post(BATCH_CREATE_ACCOUNTS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        BatchCreateAccountRes res = JSONObject.parseObject(result, BatchCreateAccountRes.class);
        log.debug("batchCreateAccounts end");
        return res;
    }

    @Override
    public QueryAccountsRes queryAccounts(QueryAccountsReq req) {
        log.debug("QueryAccountsReq {}", req);
        log.debug("queryAccounts start");
        ForestResponse response = httpClient.get(QUERY_ACCOUNTS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        QueryAccountsRes res = JSONObject.parseObject(result, QueryAccountsRes.class);
        log.debug("queryAccounts end");
        return res;
    }


    @Override
    public QueryNatAccountsHistoryRes queryNativeAccountsHistory(QueryAccountsHistoryReq req) {
        log.debug("QueryAccountsHistoryReq {}", req);
        log.debug("queryNatAccountsHistory start");
        ForestResponse response = httpClient.get(QUERY_NATIVE_ACCOUNTS_HISTORY, JSONObject.toJSONString(req));
        String result = response.readAsString();
        QueryNatAccountsHistoryRes res = JSONObject.parseObject(result, QueryNatAccountsHistoryRes.class);
        log.debug("queryNatAccountsHistory end");
        return res;
    }


    @Override
    public QueryEvmAccountsHistoryRes queryEvmAccountsHistory(QueryAccountsHistoryReq req) {
        log.debug("QueryAccountsHistoryReq {}", req);
        log.debug("queryEvmAccountsHistory start");
        ForestResponse response = httpClient.get(QUERY_EVM_ACCOUNTS_HISTORY, JSONObject.toJSONString(req));
        String result = response.readAsString();
        QueryEvmAccountsHistoryRes res = JSONObject.parseObject(result, QueryEvmAccountsHistoryRes.class);
        log.debug("queryEvmAccountsHistory end");
        return res;
    }
}
