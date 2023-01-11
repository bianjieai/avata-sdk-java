package proxy.account.impl;

import com.alibaba.fastjson.JSONObject;
import config.ConfigCache;
import constant.ErrorMessage;
import exception.SdkException;
import model.ErrorResponse;
import model.account.AccountResponse;
import okhttp3.Response;
import proxy.account.AccountProxy;
import util.HttpClient;

import java.util.HashMap;
import java.util.Map;

public class AccountClient implements AccountProxy {
    private static final String CREATE_ACCOUNT = "/v1beta1/account";
    private static final String CREATE_ACCOUNTS = "/v1beta1/accounts";

    public AccountResponse createAccount(String name, String operationId){

        // 请求body
        Map<String, Object> body = new HashMap<>();
        body.put("name", name);
        body.put("operation_id", operationId);
        String result;
        Response res;
        try {
            res = HttpClient.Post(CREATE_ACCOUNT, JSONObject.toJSONString(body));
            result = res.body().string();
        }catch (Exception e) {
            throw  new SdkException(ErrorMessage.INTERNAL_ERROR);
        }
        if (res.code() != 200){
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(res.code(), res.message(), errorResponse.getError());
        }
        AccountResponse response = JSONObject.parseObject(result, AccountResponse.class);
        response.setCode(res.code());
        response.setMessage(res.message());
        return response;
    }

}
