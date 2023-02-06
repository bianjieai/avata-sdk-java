package proxy.mt.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import constant.ErrorMessage;
import exception.SdkException;
import model.BaseResponse;
import model.ErrorResponse;
import model.PublicResponse;
import model.mt.*;
import proxy.mt.MtProxy;
import util.HttpClient;
import util.Strings;

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
        // check params
        if (Strings.isEmpty(req.getName())) {
            throw new SdkException(ErrorMessage.NAME_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOwner())) {
            throw new SdkException(ErrorMessage.OWNER_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        ForestResponse response = HttpClient.Post(CREATE_MT_CLASS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryMtClassesRes queryMtClasses(QueryMtClassesReq req) {
        ForestResponse response = HttpClient.Get(QUERY_MT_CLASSES, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryMtClassesRes res = JSONObject.parseObject(result, QueryMtClassesRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryMtClassRes queryMtClass(String classId) {
        String path = String.format(QUERY_MT_CLASS, classId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryMtClassRes res = JSONObject.parseObject(result, QueryMtClassRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse transferMtClass(TransferMtClassReq req, String classId, String owner) {
        // check params
        if (Strings.isEmpty(req.getRecipient())) {
            throw new SdkException(ErrorMessage.RECIPIENT_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(TRANSFER_MT_CLASS, classId, owner);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse createMt(CreateMtReq req, String classId) {
        // check params
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(CREATE_MT, classId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse mintMt(MintMtReq req, String classId, String mtId) {
        // check params
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(MINT_MT, classId, mtId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse transferMt(TransferMtReq req, String classId, String owner, String mtId) {
        // check params
        if (Strings.isEmpty(req.getRecipient())) {
            throw new SdkException(ErrorMessage.RECIPIENT_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(TRANSFER_MT, classId, owner, mtId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse editMt(EditMtReq req, String classId, String owner, String mtId) {
        // check params
        if (Strings.isEmpty(req.getData())) {
            throw new SdkException(ErrorMessage.DATA_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(EDIT_MT, classId, owner, mtId);
        ForestResponse response = HttpClient.Patch(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse deleteMt(DeleteMtReq req, String classId, String owner, String mtId) {
        // check params
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(DELETE_MT, classId, owner, mtId);
        ForestResponse response = HttpClient.Delete(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryMtsRes queryMts(QueryMtsReq req) {
        ForestResponse response = HttpClient.Get(QUERY_MTS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryMtsRes res = JSONObject.parseObject(result, QueryMtsRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryMtRes queryMt(String classId, String mtId) {
        String path = String.format(QUERY_MT, classId, mtId);
        ForestResponse response = HttpClient.Get(path,"");
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryMtRes res = JSONObject.parseObject(result, QueryMtRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryMtHistoryRes queryMtHistory(QueryMtHistoryReq req, String classId, String mtId) {
        String path = String.format(QUERY_MT_HISTORY, classId, mtId);
        ForestResponse response = HttpClient.Get(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryMtHistoryRes res = JSONObject.parseObject(result, QueryMtHistoryRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryMtBalancesRes queryMtBalances(QueryMtBalancesReq req, String classId, String account) {
        String path = String.format(QUERY_MT_BALANCES, classId, account);
        ForestResponse response = HttpClient.Get(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryMtBalancesRes res = JSONObject.parseObject(result, QueryMtBalancesRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }
}
