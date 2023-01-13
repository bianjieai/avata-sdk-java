package proxy.nft.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import constant.ErrorMessage;
import exception.SdkException;
import model.BaseResponse;
import model.ErrorResponse;
import model.PublicResponse;
import model.nft.*;
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
        ForestResponse response = HttpClient.Post(CREATE_CLASS, JSONObject.toJSONString(req));
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
    public QueryClassResp queryClass(QueryClassReq req) {
        ForestResponse response = HttpClient.Get(QUERY_CLASS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryClassResp res = JSONObject.parseObject(result, QueryClassResp.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryClassDetailResp queryClassDetail(String classId) {
        StringBuffer sb = new StringBuffer();
        sb.append(QUERY_CLASS_DETAIL);
        ForestResponse response = HttpClient.Get(sb.toString(), "");
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryClassDetailResp res = JSONObject.parseObject(result, QueryClassDetailResp.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
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
        sb.append("/");
        sb.append(classId);
        sb.append("/");
        sb.append(owner);
        ForestResponse response = HttpClient.Post(sb.toString(), JSONObject.toJSONString(req));
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
    public PublicResponse createNft(CreateNftReq req, String classId) {
        // check params
        if (Strings.isEmpty(req.getName())) {
            throw new SdkException(ErrorMessage.NAME_ERROR, null, null);//todo
        }
        if (Strings.isEmpty(req.getOperation_id())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);//todo
        }
        StringBuffer sb = new StringBuffer();
        sb.append(CREATE_NFT);
        sb.append(classId);
        ForestResponse response = HttpClient.Post(sb.toString(), JSONObject.toJSONString(req));
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
    public PublicResponse transferNft(TransferNftReq req, String classId, String owner, String nftId) {
        // check params
        if (Strings.isEmpty(req.getRecipient())) {
            throw new SdkException(ErrorMessage.NAME_ERROR, null, null);//todo
        }
        if (Strings.isEmpty(req.getOperation_id())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);//todo
        }
        StringBuffer sb = new StringBuffer();
        sb.append(TRANSFER_NFT);
        sb.append(classId);
        sb.append("/");
        sb.append(owner);
        sb.append("/");
        sb.append(nftId);
        ForestResponse response = HttpClient.Post(sb.toString(), JSONObject.toJSONString(req));
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
        //todo
        ForestResponse response = HttpClient.Post(sb.toString(), JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override //todo
    public PublicResponse deleteNft(DeleteNftReq req, String classId, String owner, String nftId) {
        // check params
        if (Strings.isEmpty(req.getOperation_id())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(DELETE_NFT);
        sb.append(classId);
        sb.append("/");
        sb.append(owner);
        sb.append("/");
        sb.append(nftId);
        //todo
        ForestResponse response = HttpClient.Post(sb.toString(), JSONObject.toJSONString(req));
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
    public PublicResponse batchCreateNft(BatchCreateNftReq req, String classId) {
        // check params
        if (Strings.isEmpty(req.getName())) {
            throw new SdkException(ErrorMessage.NAME_ERROR, null, null);
        }
        if (req.getRecipients() == null) {
            throw new SdkException(ErrorMessage.RECIPIENT_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOperation_id())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(BATCH_CREATE_NFT);
        sb.append(classId);
        ForestResponse response = HttpClient.Post(sb.toString(), JSONObject.toJSONString(req));
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
    public PublicResponse batchTransferNft(BatchTransferNftReq req, String owner) {
        // check params
        if (req.getData() == null) {
            throw new SdkException(ErrorMessage.DATA_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOperation_id())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(BATCH_TRANSFER_NFT);
        sb.append(owner);
        ForestResponse response = HttpClient.Post(sb.toString(), JSONObject.toJSONString(req));
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
    public PublicResponse batchEditNft(BatchEditNftReq req, String owner) {
        // check params
        if (req.getNfts() == null) {
            throw new SdkException(ErrorMessage.NFTS_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOperation_id())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(BATCH_EDIT_NFT);
        sb.append(owner);
        ForestResponse response = HttpClient.Post(sb.toString(), JSONObject.toJSONString(req));
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
    public PublicResponse batchDeleteNft(BatchDeleteNftReq req, String owner) {
        // check params
        if (req.getNfts() == null) {
            throw new SdkException(ErrorMessage.NFTS_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOperation_id())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(BATCH_DELETE_NFT);
        sb.append(owner);
        ForestResponse response = HttpClient.Post(sb.toString(), JSONObject.toJSONString(req));
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
    public QueryNftResp queryNft(QueryNftReq req) {
        ForestResponse response = HttpClient.Get(QUERY_NFT, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryNftResp res = JSONObject.parseObject(result, QueryNftResp.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryNftDetailResp queryNftDetail(String classId, String nftId) {
        StringBuffer sb = new StringBuffer();
        sb.append(QUERY_NFT_DETAIL);
        sb.append(classId);
        sb.append("/");
        sb.append(nftId);
        ForestResponse response = HttpClient.Get(sb.toString(), "");
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryNftDetailResp res = JSONObject.parseObject(result, QueryNftDetailResp.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryNftHistoryResp queryNftHistory(String classId, String nftId) {
        StringBuffer sb = new StringBuffer();
        sb.append(QUERY_NFT_HISTORY);
        sb.append(classId);
        sb.append("/");
        sb.append(nftId);
        sb.append("/");
        sb.append("history");
        ForestResponse response = HttpClient.Get(sb.toString(), "");
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryNftHistoryResp res = JSONObject.parseObject(result, QueryNftHistoryResp.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }


}