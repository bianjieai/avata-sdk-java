package ai.bianjie.avatasdk.proxy.user.impl;

import ai.bianjie.avatasdk.exception.AvataException;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.user.*;
import ai.bianjie.avatasdk.proxy.user.UserProxy;
import ai.bianjie.avatasdk.util.HttpClient;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User implements UserProxy {

    private static final String CREATE_USER = "/v3/users";// 创建用户

    private static final String UPDATE_USER = "/v3/users";// 更新用户

    private static final String QUERY_USER = "/v3/users";// 查询用户信息

    private HttpClient httpClient;

    public User(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public CreateUserRes createUser(CreateUserReq req) {
        log.debug("CreateUserReq {}", req);
        log.debug("createUser start");
        // check params
        if (req.getUserType() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "user_type"));
        }
        if (req.getName() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "name"));
        }
        if (req.getPhoneNum() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "phone_num"));
        }
        if (req.getUserType() == 1 && req.getCertificateNum() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "certificate_num"));
        }
        if (req.getUserType() == 2 && req.getRegistrationNum() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "registration_num"));
        }
        ForestResponse response = httpClient.post(CREATE_USER, JSONObject.toJSONString(req));
        CreateUserRes res = JSONObject.parseObject(response.readAsString(), CreateUserRes.class);
        log.debug("createUser end");
        return res;
    }

    @Override
    public PublicResponse updateUser(UpdateUserReq req) {
        log.debug("UpdateUserReq {}", req);
        log.debug("updateUser start");
        // check params
        if (StringUtils.isEmpty(req.getUserId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "user_id"));
        }
        if (StringUtils.isEmpty(req.getPhoneNum())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "phone_num"));
        }
        ForestResponse response = httpClient.patch(UPDATE_USER, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("updateUser end");
        return res;
    }

    @Override
    public QueryUserRes queryUser(QueryUserReq req) {
        log.debug("QueryUserReq {}", req);
        log.debug("queryUser start");
        // check params
        if (StringUtils.isEmpty(req.getUserType())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "user_type"));
        }
        if (StringUtils.isEmpty(req.getCode())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "code"));
        }
        ForestResponse response = httpClient.get(QUERY_USER, JSONObject.toJSONString(req));
        String result = response.readAsString();
        QueryUserRes res = JSONObject.parseObject(result, QueryUserRes.class);
        log.debug("queryUser end");
        return res;
    }
}
