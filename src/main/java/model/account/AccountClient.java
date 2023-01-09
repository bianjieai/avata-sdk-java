package model.account;

import okhttp3.ResponseBody;
import util.HttpReq;

public class AccountClient {

    public void createAccount(){
        HttpReq httpReq = new HttpReq();
        ResponseBody res = httpReq.Post("");
    }
}
