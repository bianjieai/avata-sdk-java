package proxy.nft.impl;

import com.alibaba.fastjson.JSONObject;
import constant.ErrorMessage;
import exception.SdkException;
import model.ErrorResponse;
import model.PublicResponse;
import model.nft.*;
import okhttp3.Response;
import proxy.nft.NftProxy;
import util.HttpClient;
import util.Strings;

import java.lang.reflect.Array;

public class NftClient implements NftProxy {
    private static final String CREATE_CLASS = "/v1beta1/nft/classes";
    private static final String QUERY_CLASS = "/v1beta1/nft/classes";
    private static final String QUERY_CLASS_DETAIL = "/v1beta1/nft/classes/";
    private static final String TRANSFER_CLASS = "/v1beta1/nft/class-transfers/";
    private static final String CREATE_NFT = "/v1beta1/nft/nfts/";
    private static final String TRANSFER_NFT = "/v1beta1/nft/nft-transfers/";
    private static final String EDIT_NFT = "/v1beta1/nft/nfts/";
    private static final String DELETE_NFT = "/v1beta1/nft/nfts/";
    private static final String BATCH_CREATE_NFT = "/v1beta1/nft/batch/nfts/";
    private static final String BATCH_TRANSFER_NFT = "/v1beta1/nft/batch/nft-transfers/";
    private static final String BATCH_EDIT_NFT = "/v1beta1/nft/batch/nfts/";
    private static final String BATCH_DELETE_NFT = "/v1beta1/nft/batch/nfts/";
    private static final String QUERY_NFT = "/v1beta1/nft/nfts";
    private static final String QUERY_NFT_DETAIL = "/v1beta1/nft/nfts/";
    private static final String QUERY_NFT_HISTORY = "/v1beta1/nft/nfts/";


    @Override
    public PublicResponse createClass(CreateClassReq req) {
        // check params
        if (Strings.isEmpty(req.getName())) {
            throw new SdkException(ErrorMessage.NAME_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOwner())) {
            throw new SdkException(ErrorMessage.OWNER_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOperation_id())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String result;
        Response res;
        try {
            res = HttpClient.Post(CREATE_CLASS, JSONObject.toJSONString(req));
            result = res.body().string();
        } catch (Exception e) {
            System.out.println(e);
            throw new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);
        }
        if (res.code() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(res.code(), res.message()));
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        response.setCode(0);
        response.setMessage("");
        return response;
    }

    @Override
    public QueryClassResp queryClass(QueryClassReq req) {
        StringBuffer sb = new StringBuffer();
        sb.append("?");
        //todo 参数拼接方法
        String result;
        Response res;
        try {
            res = HttpClient.Get(QUERY_CLASS, sb.toString());
            result = res.body().string();
        } catch (Exception e) {
            throw new SdkException(ErrorMessage.UNKNOWN_ERROR, null, null);
        }
        if (res.code() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(res.code(), res.message()));
        }
        QueryClassResp resp = JSONObject.parseObject(result, QueryClassResp.class);
        resp.setCode(res.code());
        resp.setMessage(res.message());
        return resp;
    }

    @Override
    public QueryClassDetailResp queryClassDetail(String classId) {
        StringBuffer sb = new StringBuffer();
        sb.append(QUERY_CLASS_DETAIL);
        sb.append(classId);
        String result;
        Response res;
        try {
            res = HttpClient.Get(sb.toString(), "");
            result = res.body().string();
        } catch (Exception e) {
            throw new SdkException(ErrorMessage.UNKNOWN_ERROR, null, null);
        }
        if (res.code() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(res.code(), res.message()));
        }
        QueryClassDetailResp resp = JSONObject.parseObject(result, QueryClassDetailResp.class);
        resp.setCode(res.code());
        resp.setMessage(res.message());
        return resp;
    }

    @Override //todo
    public PublicResponse transferClass(TransferClassReq req, String classId, String owner) {
        // check params
        if (Strings.isEmpty(req.getRecipient())) {
            throw new SdkException(ErrorMessage.RECIPIENT_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOperation_id())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(TRANSFER_CLASS);
        sb.append(classId);
        sb.append("/" + owner);
        String result;
        Response res;
        try {
            res = HttpClient.Post(sb.toString(), JSONObject.toJSONString(req));
            result = res.body().string();
        } catch (Exception e) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);
        }
        if (res.code() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(res.code(), res.message()));
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        response.setCode(0);
        response.setMessage("");
        return response;
    }

    @Override
    public PublicResponse createNft(CreateNftReq req, String classId) {
        // check params
        if (Strings.isEmpty(req.getName())) {
            throw new SdkException(ErrorMessage.NAME_ERROR, null, null);//todo
        }
        if (Strings.isEmpty(req.getOperation_id())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);//todo
        }
        // 请求body
        StringBuffer sb = new StringBuffer();
        sb.append(CREATE_NFT);
        sb.append(classId);
        String result;
        Response res;
        try {
            res = HttpClient.Post(sb.toString(), JSONObject.toJSONString(req));
            result = res.body().string();
        } catch (Exception e) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);
        }
        if (res.code() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(res.code(), res.message()));
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        response.setCode(0);
        response.setMessage("");
        return response;
    }
    //avataoqfkdubslm27ids1veptd32qkhd

    @Override //todo
    public PublicResponse transferNft(TransferNftReq req, String classId, String owner, String nftId) {

        return null;
    }

    @Override
    public PublicResponse editNft(EditNftReq req, String classId, String owner, String nftId) {
        // check params
        if (Strings.isEmpty(req.getName())) {
            throw new SdkException(ErrorMessage.NAME_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOperation_id())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(EDIT_NFT);
        sb.append(classId);
        sb.append("/");
        sb.append(owner);
        sb.append("/");
        sb.append(nftId);
        String result;
        Response res;
        try {//todo Patch请求
            res = HttpClient.Post(sb.toString(), JSONObject.toJSONString(req));
            result = res.body().string();
        } catch (Exception e) {
            System.out.println(e);
            throw new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);
        }
        if (res.code() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(res.code(), res.message()));
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        response.setCode(0);
        response.setMessage("");
        return response;
    }

    @Override //todo
    public PublicResponse deleteNft(DeleteNftReq req, String classId, String owner, String nftId) {
        HttpClient httpReq = new HttpClient();

        // todo 校验必填参数
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);//todo
        }

        // 请求body
        StringBuffer sb = new StringBuffer();
        sb.append(DELETE_NFT);
        sb.append(classId);
        sb.append(owner);
        sb.append(nftId);
        String result;
        try {
            Response res = httpReq.Post(sb.toString(), JSONObject.toJSONString(req));
            result = res.body().string();
        } catch (Exception e) {
            //todo err
            throw new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);//todo
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        return response;
    }

    @Override
    public PublicResponse batchCreateNft(BatchCreateNftReq req, String classId) {
        // check params
        if (Strings.isEmpty(req.getName())) {
            throw new SdkException(ErrorMessage.NAME_ERROR, null, null);//todo
        }
        if ((req.getRecipients() == null)) {
            throw new SdkException(ErrorMessage.RECIPIENT_ERROR, null, null);//todo
        }
        if (Strings.isEmpty(req.getOperation_id())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);//todo
        }
        // 请求body
        StringBuffer sb = new StringBuffer();
        sb.append(BATCH_CREATE_NFT);
        sb.append(classId);
        String result;
        Response res;
        try {
            res = HttpClient.Post(sb.toString(), JSONObject.toJSONString(req));
            result = res.body().string();
        } catch (Exception e) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);
        }
        if (res.code() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(res.code(), res.message()));
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        response.setCode(0);
        response.setMessage("");
        return response;
    }

    @Override
    public PublicResponse batchTransferNft(BatchTransferNftReq req, String owner) {
        return null;
    }

    @Override
    public PublicResponse batchEditNft(BatchEditNftReq req, String owner) {
        return null;
    }

    @Override
    public PublicResponse batchDeleteNft(BatchDeleteNftReq req, String owner) {
        return null;

    }

    @Override
    public QueryNftResp queryNft(QueryNftReq req) {
        return null;
    }

    @Override //todo
    public QueryNftDetailResp queryNftDetail(String classId, String nftId) {
        StringBuffer sb = new StringBuffer();
        sb.append(QUERY_NFT_DETAIL);
        sb.append(classId);
        String result;
        Response res;
        try {
            res = HttpClient.Get(sb.toString(), "");
            result = res.body().string();
        } catch (Exception e) {
            throw new SdkException(ErrorMessage.UNKNOWN_ERROR, null, null);
        }
        if (res.code() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(res.code(), res.message()));
        }
        QueryNftDetailResp resp = JSONObject.parseObject(result, QueryNftDetailResp.class);
        resp.setCode(res.code());
        resp.setMessage(res.message());
        return resp;
    }

    @Override
    public QueryNftHistoryResp queryNftHistory(String classId, String nftId) {
        return null;
    }


}