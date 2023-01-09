package model.account;

import okhttp3.Response;
import okhttp3.ResponseBody;
import proxy.account.AccountProxy;
import util.HttpReq;

import java.io.IOException;

public class AccountClient implements AccountProxy {

    public CreateAccountRes createAccount(String name, String operationId){
        HttpReq httpReq = new HttpReq();
        Response res = httpReq.Post("");
        //todo

        return null;
    }

}
