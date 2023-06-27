package ai.bianjie.avatasdk.proxy.evm.ns.impl;

import ai.bianjie.avatasdk.config.ConfigInfo;
import ai.bianjie.avatasdk.exception.AvataException;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.evm.ns.*;
import ai.bianjie.avatasdk.proxy.evm.ns.NsProxy;
import ai.bianjie.avatasdk.util.HttpClient;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NsClient implements NsProxy {
    private static final String REGISTER_DOMAIN = "/v3/evm/ns/domains"; // 注册域名
    private static final String QUERY_DOMAIN = "/v3/evm/ns/domains"; // 查询域名
    private static final String QUERY_OWNER_DOMAIN = "/v3/evm/ns/domains/%s"; // 查询用户域名
    private static final String TRANSFER_DOMAIN = "/v3/evm/ns/transfers/%s/%s"; // 转让域名

    private ConfigInfo configInfo;

    public NsClient(ConfigInfo configInfo) {
        this.configInfo = configInfo;
    }

    @Override
    public PublicResponse registerDomain(RegisterDomainReq req) {
        log.debug("RegisterDomainReq {}", req);
        log.debug("RegisterDomain start");
        // check params
        if (StringUtils.isEmpty(req.getName())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "name"));
        }
        if (StringUtils.isEmpty(req.getOwner())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "owner"));
        }
        if (req.getDuration() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "duration"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        ForestResponse response = HttpClient.Post(REGISTER_DOMAIN, JSONObject.toJSONString(req), configInfo);
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("RegisterDomain end");
        return res;
    }

    @Override
    public QueryDomainRes queryDomain(QueryDomainReq req) {
        log.debug("QueryDomainReq {}", req);
        log.debug("queryDomain start");
        // check params
        if (StringUtils.isEmpty(req.getName())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "name"));
        }
        ForestResponse response = HttpClient.Get(QUERY_DOMAIN, JSONObject.toJSONString(req), configInfo);
        String result = response.readAsString();
        QueryDomainRes res = JSONObject.parseObject(result, QueryDomainRes.class);
        log.debug("queryDomain end");
        return res;
    }

    @Override
    public QueryOwnerDomainRes queryOwnerDomain(QueryOwnerDomainReq req, String owner) {
        log.debug("QueryOwnerDomainReq {}", req);
        log.debug("queryOwnerDomain start");
        String path = String.format(QUERY_OWNER_DOMAIN, owner);
        ForestResponse response = HttpClient.Get(path, JSONObject.toJSONString(req), configInfo);
        String result = response.readAsString();
        QueryOwnerDomainRes res = JSONObject.parseObject(result, QueryOwnerDomainRes.class);
        log.debug("queryDomain end");
        return res;
    }

    @Override
    public PublicResponse transferDomain(TransferDomainReq req, String owner, String name) {
        log.debug("TransferDomainReq {}", req);
        log.debug("transferDomain start");
        // check params
        if (StringUtils.isEmpty(req.getRecipient())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "recipient"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(TRANSFER_DOMAIN, owner, name);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req), configInfo);
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("transferDomain end");
        return res;
    }
}
