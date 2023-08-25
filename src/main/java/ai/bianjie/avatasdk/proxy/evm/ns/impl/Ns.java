package ai.bianjie.avatasdk.proxy.evm.ns.impl;

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
public class Ns implements NsProxy {
    private static final String REGISTER_DOMAIN = "/v3/evm/ns/domains"; // 注册域名
    private static final String QUERY_DOMAIN = "/v3/evm/ns/domains"; // 查询域名
    private static final String QUERY_OWNER_DOMAIN = "/v3/evm/ns/domains/%s"; // 查询用户域名
    private static final String TRANSFER_DOMAIN = "/v3/evm/ns/transfers/%s/%s"; // 转让域名
    private static final String RESOLVE_DOMAIN = "/v3/evm/ns/resolves/%s/%s"; // 设置域名解析
    private static final String QUERY_RESOLVE_DOMAIN = "/v3/evm/ns/resolves/%s"; // 设置域名解析
    private static final String REVERSE_RESOLVE_DOMAIN = "/v3/evm/ns/reverse-resolves/%s"; // 设置域名反向解析

    private static final String QUERY_REVERSE_RESOLVE_DOMAIN = "/v3/evm/ns/reverse-resolves/%s"; // 查询域名反向解析

    private HttpClient httpClient;

    public Ns(HttpClient httpClient) {
        this.httpClient = httpClient;
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
        ForestResponse response = httpClient.post(REGISTER_DOMAIN, JSONObject.toJSONString(req));
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
        ForestResponse response = httpClient.get(QUERY_DOMAIN, JSONObject.toJSONString(req));
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
        ForestResponse response = httpClient.get(path, JSONObject.toJSONString(req));
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
        ForestResponse response = httpClient.post(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("transferDomain end");
        return res;
    }

    @Override
    public PublicResponse ResolveDomain(ResolveDomainReq req, String owner, String name) {
        log.debug("ResolveDomainReq {},owner {}, name {}", req, owner, name);
        log.debug("resolveDomain start");
        // check params
        if (req.getResolveType() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "resolve_type"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(RESOLVE_DOMAIN, owner, name);
        ForestResponse response = httpClient.post(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("resolveDomainReq end");
        return res;
    }

    @Override
    public QueryDomainResolvesRes queryDomainResolves(String name, QueryDomainResolvesReq req) {
        log.debug("name {}, QueryDomainResolvesReq {}", name, req);
        log.debug("queryDomainResolves start");
        String path = String.format(QUERY_RESOLVE_DOMAIN, name, req);
        ForestResponse response = httpClient.get(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        QueryDomainResolvesRes res = JSONObject.parseObject(result, QueryDomainResolvesRes.class);
        log.debug("queryDomainResolves end");
        return res;
    }

    @Override
    public PublicResponse reverseResolveDomain(ReverseResolveDomainReq req, String owner) {
        log.debug("ReverseResolveDomainReq {}, owner {}", req, owner);
        log.debug("resolveDomain start");
        String path = String.format(REVERSE_RESOLVE_DOMAIN, owner);
        ForestResponse response = httpClient.post(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("resolveDomain end");
        return res;
    }

    @Override
    public QueryReverseResolveDomainRes queryReverseResolveDomain(String owner) {
        log.debug("owner {}", owner);
        log.debug("queryReverseResolveDomain start");
        String path = String.format(QUERY_REVERSE_RESOLVE_DOMAIN, owner);
        ForestResponse response = httpClient.get(path, "");
        String result = response.readAsString();
        QueryReverseResolveDomainRes res = JSONObject.parseObject(result, QueryReverseResolveDomainRes.class);
        log.debug("queryReverseResolveDomain end");
        return res;
    }
}

