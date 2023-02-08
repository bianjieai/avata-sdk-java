package proxy.mt.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import exception.AvataException;
import lombok.extern.slf4j.Slf4j;
import model.BaseResponse;
import model.PublicResponse;
import model.mt.*;
import proxy.mt.MtProxy;
import util.HttpClient;
import com.dtflys.forest.utils.StringUtils;

@Slf4j
public class MtClient implements MtProxy {
    private static final String CREATE_MT_CLASS = "/v1beta1/mt/classes";
    private static final String QUERY_MT_CLASSES = "/v1beta1/mt/classes";
    private static final String QUERY_MT_CLASS = "/v1beta1/mt/classes/%s";
    private static final String TRANSFER_MT_CLASS = "/v1beta1/mt/class-transfers/%s/%s";
    private static final String CREATE_MT = "/v1beta1/mt/mt-issues/%s";
    private static final String MINT_MT = "/v1beta1/mt/mt-mints/%s/%s";
    private static final String TRANSFER_MT = "/v1beta1/mt/mt-transfers/%s/%s/%s";
    private static final String EDIT_MT = "/v1beta1/mt/mts/%s/%s/%s";
    private static final String DELETE_MT = "/v1beta1/mt/mts/%s/%s/%s";
    private static final String QUERY_MTS = "/v1beta1/mt/mts";
    private static final String QUERY_MT = "/v1beta1/mt/mts/%s/%s";
    private static final String QUERY_MT_HISTORY = "/v1beta1/mt/mts/%s/%s/history";
    private static final String QUERY_MT_BALANCES = "/v1beta1/mt/mts/%s/%s/balances";

    @Override
    public PublicResponse createMtClass(CreateMtClassReq req) {
        log.debug("CreateMtClassReq {}", req);
        log.info("createMtClass start");
        // check params
        if (StringUtils.isEmpty(req.getName())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "name"));
        }
        if (StringUtils.isEmpty(req.getOwner())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "owner"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        ForestResponse response = HttpClient.Post(CREATE_MT_CLASS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("createMtClass end");
        return res;
    }

    @Override
    public QueryMtClassesRes queryMtClasses(QueryMtClassesReq req) {
        log.debug("QueryMtClassesReq {}", req);
        log.info("queryMtClasses start");
        ForestResponse response = HttpClient.Get(QUERY_MT_CLASSES, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        QueryMtClassesRes res = JSONObject.parseObject(result, QueryMtClassesRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("queryMtClasses end");
        return res;
    }

    @Override
    public QueryMtClassRes queryMtClass(String classId) {
        log.debug("classId {}", classId);
        log.info("queryMtClasses start");
        String path = String.format(QUERY_MT_CLASS, classId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        
        QueryMtClassRes res = JSONObject.parseObject(result, QueryMtClassRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse transferMtClass(TransferMtClassReq req, String classId, String owner) {
        log.debug("TransferMtClassReq {}, classId {}, owner {}", req, classId, owner);
        log.info("transferMtClass start");
        // check params
        if (StringUtils.isEmpty(req.getRecipient())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "recipient"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(TRANSFER_MT_CLASS, classId, owner);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("transferMtClass end");
        return res;
    }

    @Override
    public PublicResponse createMt(IssueMtReq req, String classId) {
        log.debug("IssueMtReq {}, classId {}", req, classId);
        log.info("createMt start");
        // check params
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(CREATE_MT, classId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("createMt end");
        return res;
    }

    @Override
    public PublicResponse mintMt(MintMtReq req, String classId, String mtId) {
        log.debug("MintMtReq {}, classId {}, mtId {}", req, classId, mtId);
        log.info("mintMt start");
        // check params
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(MINT_MT, classId, mtId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("mintMt end");
        return res;
    }

    @Override
    public PublicResponse transferMt(TransferMtReq req, String classId, String owner, String mtId) {
        log.debug("TransferMtReq {}, classId {}, owner {}, mtId {}", req, classId, owner, mtId);
        log.info("transferMt start");
        // check params
        if (StringUtils.isEmpty(req.getRecipient())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "recipient"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(TRANSFER_MT, classId, owner, mtId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("transferMt end");
        return res;
    }

    @Override
    public PublicResponse editMt(EditMtReq req, String classId, String owner, String mtId) {
        log.debug("EditMtReq {}, classId {}, owner {}, mtId {}", req, classId, owner, mtId);
        log.info("editMt start");
        // check params
        if (StringUtils.isEmpty(req.getData())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "date"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(EDIT_MT, classId, owner, mtId);
        ForestResponse response = HttpClient.Patch(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("editMt end");
        return res;
    }

    @Override
    public PublicResponse deleteMt(BurnMtReq req, String classId, String owner, String mtId) {
        log.debug("BurnMtReq {}, classId {}, owner {}, mtId {}", req, classId, owner, mtId);
        log.info("deleteMt start");
        // check params
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(DELETE_MT, classId, owner, mtId);
        ForestResponse response = HttpClient.Delete(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("deleteMt end");
        return res;
    }

    @Override
    public QueryMtsRes queryMts(QueryMtsReq req) {
        log.debug("QueryMtsReq {}", req);
        log.info("queryMts start");
        ForestResponse response = HttpClient.Get(QUERY_MTS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        QueryMtsRes res = JSONObject.parseObject(result, QueryMtsRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("queryMts end");
        return res;
    }

    @Override
    public QueryMtRes queryMt(String classId, String mtId) {
        log.debug("classId {}, mtId {}", classId, mtId);
        log.info("queryMt start");
        String path = String.format(QUERY_MT, classId, mtId);
        ForestResponse response = HttpClient.Get(path,"");
        String result = response.readAsString();
        
        QueryMtRes res = JSONObject.parseObject(result, QueryMtRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("queryMt end");
        return res;
    }

    @Override
    public QueryMtHistoryRes queryMtHistory(QueryMtHistoryReq req, String classId, String mtId) {
        log.debug("QueryMtHistoryReq {}, classId {}, mtId {}", req, classId, mtId);
        log.info("queryMtHistory start");
        String path = String.format(QUERY_MT_HISTORY, classId, mtId);
        ForestResponse response = HttpClient.Get(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        QueryMtHistoryRes res = JSONObject.parseObject(result, QueryMtHistoryRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("queryMtHistory end");
        return res;
    }

    @Override
    public QueryMtBalancesRes queryMtBalances(QueryMtBalancesReq req, String classId, String account) {
        log.debug("QueryMtBalancesReq {}, classId {}, account {}", req, classId, account);
        log.info("queryMtBalances start");
        String path = String.format(QUERY_MT_BALANCES, classId, account);
        ForestResponse response = HttpClient.Get(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        QueryMtBalancesRes res = JSONObject.parseObject(result, QueryMtBalancesRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("queryMtBalances end");
        return res;
    }
}
