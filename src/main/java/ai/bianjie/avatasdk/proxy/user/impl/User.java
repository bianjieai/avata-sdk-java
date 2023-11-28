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

    private static final String CREATE_USER = "/v3/users"; // 创建钱包用户

    private static final String UPDATE_USER = "/v3/users"; // 更新钱包用户

    private static final String KYC_USER = "/v3/users/kyc"; // 认证钱包用户

    private static final String QUERY_USER = "/v3/users"; // 查询钱包用户信息

    private HttpClient httpClient;

    public User(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public CreateUserRes createUser(CreateUserReq req) {
        log.debug("CreateUserReq {}", req);
        log.debug("createUser start");
        // check params
        if (req.getUserType() != null) {
            if ((req.getUserType() == 1 || req.getUserType() == 2) && req.getName() == null) {
                throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "name"));
            }
            if (req.getUserType() == 1 && req.getCertificateNum() == null) {
                throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "certificate_num"));
            }
            if (req.getUserType() == 2 && req.getRegistrationNum() == null) {
                throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "registration_num"));
            }
        }
        if (req.getPhoneNum() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "phone_num"));
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
    public PublicResponse kycUser(KycUserReq req) {
        log.debug("KycUserReq {}", req);
        log.debug("kycUser start");
        // check params
        if (req.getUserType() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "user_type"));
        }
        if (StringUtils.isEmpty(req.getUserId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "user_id"));
        }
        if (StringUtils.isEmpty(req.getName())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "name"));
        }
        if (req.getUserType() == 1 && StringUtils.isEmpty(req.getCertificateNum())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "certificate_num"));
        }
        if (req.getUserType() == 2 && StringUtils.isEmpty(req.getRegistrationNum())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "registration_num"));
        }
        ForestResponse response = httpClient.post(KYC_USER, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("kycUser end");
        return res;
    }

    @Override
    public QueryUserRes queryUser(QueryUserReq req) {
        log.debug("QueryUserReq {}", req);
        log.debug("queryUser start");
        // check params
        if (StringUtils.isEmpty(req.getPhoneNum())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "phone_num"));
        }
        ForestResponse response = httpClient.get(QUERY_USER, JSONObject.toJSONString(req));
        QueryUserRes res = JSONObject.parseObject(response.readAsString(), QueryUserRes.class);
        log.debug("queryUser end");
        return res;
    }
}
