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
        HttpClient httpReq = new HttpClient();
        // todo 校验必填参数
        if (Strings.isEmpty(req.getName())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }
        if (Strings.isEmpty(req.getOwner())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }
        if (Strings.isEmpty(req.getOperation_id())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }
        // 请求body
        String result;
        Response res;
        try {
            res = httpReq.Post(CREATE_CLASS, JSONObject.toJSONString(req));
            result = res.body().string();
        } catch (Exception e) {
            // todo 定义错误类型
            throw new SdkException(ErrorMessage.UNKNOWN_ERROR);
        }
        if (res.code() != 200) {
            System.out.println("-------");
            throw new SdkException(res.code(), res.message(), null);
        }
        PublicResponse resp = JSONObject.parseObject(result, PublicResponse.class);
        resp.setCode(res.code());
        resp.setMessage(res.message());
        return resp;
    }

    @Override
    public QueryClassResp queryClass(QueryClassReq req) {
        HttpClient httpReq = new HttpClient();
        //如果要加查询条件
        StringBuffer sb = new StringBuffer();
        sb.append(QUERY_CLASS);
        sb.append(req.getName());
        String result;
        try {
            Response res = httpReq.Get(sb.toString(), "");
            result = res.body().string();
        } catch (Exception e) {
            // todo 定义错误类型
            throw new SdkException(ErrorMessage.UNKNOWN_ERROR);
        }
        QueryClassResp response = JSONObject.parseObject(result, QueryClassResp.class);
        return response;
    }

    @Override
    public QueryClassDetailResp queryClassDetail(String classId) {
        HttpClient httpReq = new HttpClient();
        StringBuffer sb = new StringBuffer();
        sb.append(QUERY_CLASS_DETAIL);
        sb.append(classId);
        String result;
        try {
            Response res = httpReq.Get(sb.toString(), "");
            result = res.body().string();
        } catch (Exception e) {
            // todo 定义错误类型
            throw new SdkException(ErrorMessage.UNKNOWN_ERROR);
        }
        QueryClassDetailResp res = JSONObject.parseObject(result, QueryClassDetailResp.class);
        return res;
    }

    @Override
    public PublicResponse transferClass(TransferClassReq req, String classId, String owner) {
        HttpClient httpReq = new HttpClient();

        // todo 校验必填参数
        if (Strings.isEmpty(req.getRecipient())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }

        // 请求body
        StringBuffer sb = new StringBuffer();
        sb.append(TRANSFER_CLASS);
        sb.append(classId);
        sb.append(owner);
        String result;
        Response res;
        try {
            res = httpReq.Post(sb.toString(), JSONObject.toJSONString(req));
            result = res.body().string();
        } catch (Exception e) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);
        }
        if (res.code() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(res.code(), res.message(), errorResponse.getError());
        }
        PublicResponse resp = JSONObject.parseObject(result, PublicResponse.class);
        resp.setCode(res.code());
        resp.setMessage(res.message());
        return resp;
    }

    @Override
    public PublicResponse createNft(CreateNftReq req, String classId) {
        HttpClient httpReq = new HttpClient();

        // todo 校验必填参数
        if (Strings.isEmpty(createNftRequest.getName())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);//todo
        if (Strings.isEmpty(req.getName())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }
        if (Strings.isEmpty(createNftRequest.getOperationId())){
            throw new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);//todo
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }
        // 请求body
        StringBuffer sb = new StringBuffer();
        sb.append(CREATE_NFT);
        sb.append(classId);
        String result;
        Response res;
        try {
            res = httpReq.Post(sb.toString(), JSONObject.toJSONString(req));
            result = res.body().string();
        } catch (Exception e) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        return response;
    }

    @Override
    public PublicResponse transferNft(TransferNftReq req, String classId, String owner, String nftId) {
        HttpClient httpReq = new HttpClient();
        // todo 校验必填参数
        if (Strings.isEmpty(req.getRecipient())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }

        // 请求body
        StringBuffer sb = new StringBuffer();
        sb.append(TRANSFER_NFT);
        sb.append(classId);
        sb.append(owner);
        sb.append(nftId);
        String result;
        try {
            Response res = httpReq.Post(sb.toString(), JSONObject.toJSONString(req));
            result = res.body().string();
        } catch (Exception e) {
            //todo err
            throw new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        return response;
    }

    @Override
    public PublicResponse editNft(EditNftReq req, String classId, String owner, String nftId) {
        return null;
    }

    @Override
    public PublicResponse deleteNft(DeleteNftReq req, String classId, String owner, String nftId) {
        HttpClient httpReq = new HttpClient();

        // todo 校验必填参数
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
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
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        return response;
    }

    @Override
    public PublicResponse batchCreateNft(BatchCreateNftReq req, String classId){
        return null;
    }

    @Override
    public PublicResponse batchTransferNft(BatchTransferNftReq req, String owner){
        return null;
    }

    @Override
    public PublicResponse batchEditNft(BatchEditNftReq req, String owner){
        return null;
    }

    @Override
    public PublicResponse batchDeleteNft(BatchDeleteNftReq req, String owner){
        return null;

    }

    @Override
    public QueryNftResp queryNft(QueryNftReq req){
        return null;
    }

    @Override
    public QueryNftDetailResp queryNftDetail(String classId, String nftId){
        return null;
    }

    @Override
    public QueryNftHistoryResp queryNftHistory(String classId, String nftId){
        return null;
    }
}
