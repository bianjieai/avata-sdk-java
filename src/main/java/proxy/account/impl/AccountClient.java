package proxy.account.impl;

import com.alibaba.fastjson.JSONObject;
import constant.ErrorMessage;
import exception.SdkException;
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
        HttpClient httpReq = new HttpClient();

        // 请求body
        Map<String, Object> body = new HashMap<>();
        body.put("name", name);
        body.put("operation_id", operationId);
        String result;
        try {
            Response res = httpReq.Post(CREATE_ACCOUNT, JSONObject.toJSONString(body));
            result = res.body().string();
        }catch (Exception e) {
            //todo err
            throw  new SdkException(ErrorMessage.INTERNAL_ERROR);
        }
        AccountResponse response = JSONObject.parseObject(result, AccountResponse.class);
        return response;
    }

}
