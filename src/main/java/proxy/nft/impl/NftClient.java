package proxy.nft.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import constant.ErrorMessage;
import exception.AvataException;
import model.BaseResponse;
import model.ErrorResponse;
import model.PublicResponse;
import model.nft.*;
import proxy.nft.NftProxy;
import util.HttpClient;
import com.dtflys.forest.utils.StringUtils;


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
    public PublicResponse createClass(CreateNftClassReq req) {
        // check params
        if (StringUtils.isEmpty(req.getName())) {
            throw new AvataException(ErrorMessage.NAME_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getOwner())) {
            throw new AvataException(ErrorMessage.OWNER_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw new AvataException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        ForestResponse response = HttpClient.Post(CREATE_CLASS, JSONObject.toJSONString(req));

        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryNftClassesRes queryClasses(QueryNftClassesReq req) {
        ForestResponse response = HttpClient.Get(QUERY_CLASSES,JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryNftClassesRes res = JSONObject.parseObject(result, QueryNftClassesRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryNftClassRes queryClass(String classId) {
        String path = String.format(QUERY_CLASS, classId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryNftClassRes res = JSONObject.parseObject(result, QueryNftClassRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse transferClass(TransferNftClassReq req, String classId, String owner) {
        // check params
        if (StringUtils.isEmpty(req.getRecipient())) {
            throw new AvataException(ErrorMessage.RECIPIENT_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw new AvataException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(TRANSFER_CLASS, classId, owner);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;

    }

    @Override
    public PublicResponse createNft(MintNftReq req, String classId) {
        // check params
        if (StringUtils.isEmpty(req.getName())) {
            throw new AvataException(ErrorMessage.NAME_ERROR, null, null);//todo
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw new AvataException(ErrorMessage.OPERATION_ID_ERROR, null, null);//todo
        }
        String path = String.format(CREATE_NFT, classId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse transferNft(TransferNftReq req, String classId, String owner, String nftId) {
        // check params
        if (StringUtils.isEmpty(req.getRecipient())) {
            throw new AvataException(ErrorMessage.RECIPIENT_ERROR, null, null);//todo
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw new AvataException(ErrorMessage.OPERATION_ID_ERROR, null, null);//todo
        }
        String path = String.format(TRANSFER_NFT, classId, owner, nftId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse editNft(EditNftReq req, String classId, String owner, String nftId) {
        // check params
        if (StringUtils.isEmpty(req.getName())) {
            throw new AvataException(ErrorMessage.NAME_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw new AvataException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(EDIT_NFT, classId, owner, nftId);
        ForestResponse response = HttpClient.Patch(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse deleteNft(BurnNftReq req, String classId, String owner, String nftId) {
        // check params
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw new AvataException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(DELETE_NFT, classId, owner, nftId);
        ForestResponse response = HttpClient.Delete(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse batchCreateNft(BatchMintNftReq req, String classId) {
        // check params
        if (StringUtils.isEmpty(req.getName())) {
            throw new AvataException(ErrorMessage.NAME_ERROR, null, null);
        }
        if (req.getRecipients() == null) {
            throw new AvataException(ErrorMessage.RECIPIENT_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw new AvataException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(BATCH_CREATE_NFT, classId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse batchTransferNft(BatchTransferNftReq req, String owner) {
        // check params
        if (req.getData() == null) {
            throw new AvataException(ErrorMessage.DATA_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw new AvataException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(BATCH_TRANSFER_NFT, owner);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;

    }

    @Override
    public PublicResponse batchEditNft(BatchEditNftReq req, String owner) {
        // check params
        if (req.getNfts() == null) {
            throw new AvataException(ErrorMessage.NFTS_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw new AvataException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(BATCH_EDIT_NFT, owner);
        ForestResponse response = HttpClient.Patch(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public PublicResponse batchDeleteNft(BatchBurnNftReq req, String owner) {
        // check params
        if (req.getNfts() == null) {
            throw new AvataException(ErrorMessage.NFTS_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw new AvataException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        String path = String.format(BATCH_DELETE_NFT, owner);
        ForestResponse response = HttpClient.Delete(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryNftsRes queryNfts(QueryNftsReq req) {
        ForestResponse response = HttpClient.Get(QUERY_NFTS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryNftsRes res = JSONObject.parseObject(result, QueryNftsRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryNftRes queryNft(String classId, String nftId) {
        String path = String.format(QUERY_NFT, classId,nftId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryNftRes res = JSONObject.parseObject(result, QueryNftRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

    @Override
    public QueryNftHistoryRes queryNftHistory(String classId, String nftId) {
        String path = String.format(QUERY_NFT_HISTORY, classId,nftId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        QueryNftHistoryRes res = JSONObject.parseObject(result, QueryNftHistoryRes.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }

}