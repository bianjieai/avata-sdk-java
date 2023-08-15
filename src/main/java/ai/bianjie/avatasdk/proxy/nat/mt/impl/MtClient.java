package ai.bianjie.avatasdk.proxy.nat.mt.impl;

import ai.bianjie.avatasdk.exception.AvataException;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.nat.mt.*;
import ai.bianjie.avatasdk.proxy.nat.mt.MtProxy;
import ai.bianjie.avatasdk.util.HttpClient;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MtClient implements MtProxy {
    private static final String CREATE_MT_CLASS = "/v3/native/mt/classes";
    private static final String QUERY_MT_CLASSES = "/v3/native/mt/classes";
    private static final String QUERY_MT_CLASS = "/v3/native/mt/classes/%s";
    private static final String TRANSFER_MT_CLASS = "/v3/native/mt/class-transfers/%s/%s";
    private static final String CREATE_MT = "/v3/native/mt/mt-issues/%s";
    private static final String MINT_MT = "/v3/native/mt/mt-mints/%s/%s";
    private static final String TRANSFER_MT = "/v3/native/mt/mt-transfers/%s/%s/%s";
    private static final String EDIT_MT = "/v3/native/mt/mts/%s/%s/%s";
    private static final String DELETE_MT = "/v3/native/mt/mts/%s/%s/%s";
    private static final String QUERY_MTS = "/v3/native/mt/mts";
    private static final String QUERY_MT = "/v3/native/mt/mts/%s/%s";
    private static final String QUERY_MT_HISTORY = "/v3/native/mt/mts/%s/%s/history";
    private static final String QUERY_MT_BALANCES = "/v3/native/mt/mts/%s/%s/balances";

    private HttpClient httpClient;

    public MtClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public PublicResponse createMtClass(CreateMtClassReq req) {
        log.debug("CreateMtClassReq {}", req);
        log.debug("createMtClass start");
        // check params
        if (StringUtils.isEmpty(req.getName())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "name"));
        }
        if (StringUtils.isEmpty(req.getOwner())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "owner"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        ForestResponse response = httpClient.post(CREATE_MT_CLASS, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("createMtClass end");
        return res;
    }

    @Override
    public QueryMtClassesRes queryMtClasses(QueryMtClassesReq req) {
        log.debug("QueryMtClassesReq {}", req);
        log.debug("queryMtClasses start");
        ForestResponse response = httpClient.get(QUERY_MT_CLASSES, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        QueryMtClassesRes res = JSONObject.parseObject(result, QueryMtClassesRes.class);
        
        log.debug("queryMtClasses end");
        return res;
    }

    @Override
    public QueryMtClassRes queryMtClass(String classId) {
        log.debug("classId {}", classId);
        log.debug("queryMtClasses start");
        String path = String.format(QUERY_MT_CLASS, classId);
        ForestResponse response = httpClient.get(path, "");
        String result = response.readAsString();
        
        QueryMtClassRes res = JSONObject.parseObject(result, QueryMtClassRes.class);
        
        return res;
    }

    @Override
    public PublicResponse transferMtClass(TransferMtClassReq req, String classId, String owner) {
        log.debug("TransferMtClassReq {}, classId {}, owner {}", req, classId, owner);
        log.debug("transferMtClass start");
        // check params
        if (StringUtils.isEmpty(req.getRecipient())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "recipient"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(TRANSFER_MT_CLASS, classId, owner);
        ForestResponse response = httpClient.post(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("transferMtClass end");
        return res;
    }

    @Override
    public PublicResponse createMt(IssueMtReq req, String classId) {
        log.debug("IssueMtReq {}, classId {}", req, classId);
        log.debug("createMt start");
        // check params
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(CREATE_MT, classId);
        ForestResponse response = httpClient.post(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("createMt end");
        return res;
    }

    @Override
    public PublicResponse mintMt(MintMtReq req, String classId, String mtId) {
        log.debug("MintMtReq {}, classId {}, mtId {}", req, classId, mtId);
        log.debug("mintMt start");
        // check params
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(MINT_MT, classId, mtId);
        ForestResponse response = httpClient.post(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("mintMt end");
        return res;
    }

    @Override
    public PublicResponse transferMt(TransferMtReq req, String classId, String owner, String mtId) {
        log.debug("TransferMtReq {}, classId {}, owner {}, mtId {}", req, classId, owner, mtId);
        log.debug("transferMt start");
        // check params
        if (StringUtils.isEmpty(req.getRecipient())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "recipient"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(TRANSFER_MT, classId, owner, mtId);
        ForestResponse response = httpClient.post(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("transferMt end");
        return res;
    }

    @Override
    public PublicResponse editMt(EditMtReq req, String classId, String owner, String mtId) {
        log.debug("EditMtReq {}, classId {}, owner {}, mtId {}", req, classId, owner, mtId);
        log.debug("editMt start");
        // check params
        if (StringUtils.isEmpty(req.getData())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "date"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(EDIT_MT, classId, owner, mtId);
        ForestResponse response = httpClient.patch(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("editMt end");
        return res;
    }

    @Override
    public PublicResponse deleteMt(BurnMtReq req, String classId, String owner, String mtId) {
        log.debug("BurnMtReq {}, classId {}, owner {}, mtId {}", req, classId, owner, mtId);
        log.debug("deleteMt start");
        // check params
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(DELETE_MT, classId, owner, mtId);
        ForestResponse response = httpClient.delete(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("deleteMt end");
        return res;
    }

    @Override
    public QueryMtsRes queryMts(QueryMtsReq req) {
        log.debug("QueryMtsReq {}", req);
        log.debug("queryMts start");
        ForestResponse response = httpClient.get(QUERY_MTS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        QueryMtsRes res = JSONObject.parseObject(result, QueryMtsRes.class);
        
        log.debug("queryMts end");
        return res;
    }

    @Override
    public QueryMtRes queryMt(String classId, String mtId) {
        log.debug("classId {}, mtId {}", classId, mtId);
        log.debug("queryMt start");
        String path = String.format(QUERY_MT, classId, mtId);
        ForestResponse response = httpClient.get(path,"");
        String result = response.readAsString();
        
        QueryMtRes res = JSONObject.parseObject(result, QueryMtRes.class);
        
        log.debug("queryMt end");
        return res;
    }

    @Override
    public QueryMtHistoryRes queryMtHistory(QueryMtHistoryReq req, String classId, String mtId) {
        log.debug("QueryMtHistoryReq {}, classId {}, mtId {}", req, classId, mtId);
        log.debug("queryMtHistory start");
        String path = String.format(QUERY_MT_HISTORY, classId, mtId);
        ForestResponse response = httpClient.get(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        QueryMtHistoryRes res = JSONObject.parseObject(result, QueryMtHistoryRes.class);
        
        log.debug("queryMtHistory end");
        return res;
    }

    @Override
    public QueryMtBalancesRes queryMtBalances(QueryMtBalancesReq req, String classId, String account) {
        log.debug("QueryMtBalancesReq {}, classId {}, account {}", req, classId, account);
        log.debug("queryMtBalances start");
        String path = String.format(QUERY_MT_BALANCES, classId, account);
        ForestResponse response = httpClient.get(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        QueryMtBalancesRes res = JSONObject.parseObject(result, QueryMtBalancesRes.class);
        
        log.debug("queryMtBalances end");
        return res;
    }
}
