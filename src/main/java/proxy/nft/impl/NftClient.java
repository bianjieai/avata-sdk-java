package proxy.nft.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import constant.ErrorMessage;
import exception.SdkException;
import model.ErrorResponse;
import model.PublicResponse;
import model.account.CreateAccountRes;
import model.nft.*;
import model.tx.QueryTxResponse;
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
        ForestResponse response = HttpClient.Post(CREATE_CLASS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        return res;
    }

    @Override
    public QueryClassResp queryClass(QueryClassReq req) {
        StringBuffer sb = new StringBuffer();
        sb.append(QUERY_CLASS);
        ForestResponse response = HttpClient.Get(sb.toString(), JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryClassResp res = JSONObject.parseObject(result, QueryClassResp.class);
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
        return res;
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
        ForestResponse response = HttpClient.Post(TRANSFER_CLASS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
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
        ForestResponse response = HttpClient.Post(CREATE_NFT, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        return res;
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
        ForestResponse response = HttpClient.Post(EDIT_NFT, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        return res;
    }

    @Override //todo
    public PublicResponse deleteNft(DeleteNftReq req, String classId, String owner, String nftId) {

    }

    @Override
    public PublicResponse batchCreateNft(BatchCreateNftReq req, String classId) {

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

    }

    @Override
    public QueryNftHistoryResp queryNftHistory(String classId, String nftId) {
        return null;
    }


}