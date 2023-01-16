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
    private static final String QUERY_CLASSES = "/v1beta1/nft/classes";
    private static final String QUERY_CLASS= "/v1beta1/nft/classes/%s";
    private static final String TRANSFER_CLASS = "/v1beta1/nft/class-transfers/%s/%s";
    private static final String CREATE_NFT = "/v1beta1/nft/nfts/%s";
    private static final String TRANSFER_NFT = "/v1beta1/nft/nft-transfers/%s/%s/%s";
    private static final String EDIT_NFT = "/v1beta1/nft/nfts/%s/%s/%s";
    private static final String DELETE_NFT = "/v1beta1/nft/nfts/%s/%s/%s";
    private static final String BATCH_CREATE_NFT = "/v1beta1/nft/batch/nfts/%s";
    private static final String BATCH_TRANSFER_NFT = "/v1beta1/nft/batch/nft-transfers/%s";
    private static final String BATCH_EDIT_NFT = "/v1beta1/nft/batch/nfts/%s";
    private static final String BATCH_DELETE_NFT = "/v1beta1/nft/batch/nfts/%s";
    private static final String QUERY_NFTS = "/v1beta1/nft/nfts";
    private static final String QUERY_NFT= "/v1beta1/nft/nfts/%s/%s";
    private static final String QUERY_NFT_HISTORY = "/v1beta1/nft/nfts/%s/%s/history";


    @Override
    public PublicResponse createClass(CreateClassReq req) {
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
        ForestResponse response = HttpClient.Post(CREATE_CLASS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.isError()){
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            System.out.println(errorResponse);
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryClassesResp queryClasses(QueryClassesReq req) {
        ForestResponse response = HttpClient.Get(QUERY_CLASSES,JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.isError()) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryClassesResp res = JSONObject.parseObject(result, QueryClassesResp.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryClassResp queryClass(String classId) {
        String path = String.format(QUERY_CLASS, classId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        if (response.isError()) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryClassResp res = JSONObject.parseObject(result, QueryClassResp.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse transferClass(TransferClassReq req, String classId, String owner) {
        // check params
        if (Strings.isEmpty(req.getRecipient())) {
            throw new SdkException(ErrorMessage.RECIPIENT_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(TRANSFER_CLASS, classId, owner);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.isError()) {
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
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);//todo
        }
        String path = String.format(CREATE_NFT, classId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.isError()) {
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
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);//todo
        }
        String path = String.format(TRANSFER_NFT, classId, owner, nftId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.isError()) {
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
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(EDIT_NFT, classId, owner, nftId);
        ForestResponse response = HttpClient.Patch(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.isError()) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse deleteNft(DeleteNftReq req, String classId, String owner, String nftId) {
        // check params
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(DELETE_NFT, classId, owner, nftId);
        ForestResponse response = HttpClient.Delete(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.isError()) {
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
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(BATCH_CREATE_NFT, classId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.isError()) {
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
        String path = String.format(BATCH_TRANSFER_NFT, owner);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.isError()) {
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
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(BATCH_EDIT_NFT);
        sb.append(owner);
        ForestResponse response = HttpClient.Patch(sb.toString(), JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.isError()) {
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
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(BATCH_DELETE_NFT, owner);
        ForestResponse response = HttpClient.Delete(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.isError()) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryNftsResp queryNfts(QueryNftsReq req) {
        ForestResponse response = HttpClient.Get(QUERY_NFTS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.isError()) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryNftsResp res = JSONObject.parseObject(result, QueryNftsResp.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryNftResp queryNft(String classId, String nftId) {
        String path = String.format(QUERY_NFT, classId,nftId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        if (response.isError()) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryNftResp res = JSONObject.parseObject(result, QueryNftResp.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryNftHistoryResp queryNftHistory(String classId, String nftId) {
        String path = String.format(QUERY_NFT_HISTORY, classId,nftId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        if (response.isError()) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryNftHistoryResp res = JSONObject.parseObject(result, QueryNftHistoryResp.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

}