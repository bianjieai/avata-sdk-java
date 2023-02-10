package ai.bianjie.avatasdk.proxy.nft.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import ai.bianjie.avatasdk.exception.AvataException;
import lombok.extern.slf4j.Slf4j;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.nft.*;
import ai.bianjie.avatasdk.proxy.nft.NftProxy;
import ai.bianjie.avatasdk.util.HttpClient;
import com.dtflys.forest.utils.StringUtils;

@Slf4j
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
        log.debug("CreateMtClassReq {}", req);
        log.debug("createClass start");
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
        ForestResponse response = HttpClient.Post(CREATE_CLASS, JSONObject.toJSONString(req));

        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("createClass end");
        return res;
    }

    @Override
    public QueryNftClassesRes queryClasses(QueryNftClassesReq req) {
        log.debug("QueryNftClassesReq {}", req);
        log.debug("queryClasses start");
        ForestResponse response = HttpClient.Get(QUERY_CLASSES,JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        QueryNftClassesRes res = JSONObject.parseObject(result, QueryNftClassesRes.class);
        
        log.debug("queryClasses end");
        return res;
    }

    @Override
    public QueryNftClassRes queryClass(String classId) {
        log.debug("classId {}", classId);
        log.debug("queryClass start");
        String path = String.format(QUERY_CLASS, classId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        
        QueryNftClassRes res = JSONObject.parseObject(result, QueryNftClassRes.class);
        
        log.debug("queryClass end");
        return res;
    }

    @Override
    public PublicResponse transferClass(TransferNftClassReq req, String classId, String owner) {
        log.debug("TransferNftClassReq {}, classId {}, owner {}", req, classId, owner);
        log.debug("transferClass start");
        // check params
        if (StringUtils.isEmpty(req.getRecipient())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "recipient"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(TRANSFER_CLASS, classId, owner);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("transferClass end");
        return res;

    }

    @Override
    public PublicResponse createNft(MintNftReq req, String classId) {
        log.debug("MintNftReq {}, classId {}", req, classId);
        log.debug("createNft start");
        // check params
        if (StringUtils.isEmpty(req.getName())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "name"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(CREATE_NFT, classId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("createNft end");
        return res;
    }

    @Override
    public PublicResponse transferNft(TransferNftReq req, String classId, String owner, String nftId) {
        log.debug("TransferNftReq {}, classId {}, owner {}, nftId {}", req, classId, owner, nftId);
        log.debug("transferNft start");
        // check params
        if (StringUtils.isEmpty(req.getRecipient())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "recipient"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(TRANSFER_NFT, classId, owner, nftId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        String result = response.readAsString();

        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        
        log.debug("transferNft end");
        return res;
    }

    @Override
    public PublicResponse editNft(EditNftReq req, String classId, String owner, String nftId) {
        log.debug("EditNftReq {}, classId {}, owner {}, nftId {}", req, classId, owner, nftId);
        log.debug("editNft start");
        // check params
        if (StringUtils.isEmpty(req.getName())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "name"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(EDIT_NFT, classId, owner, nftId);
        ForestResponse response = HttpClient.Patch(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("editNft end");
        return res;
    }

    @Override
    public PublicResponse burnNft(BurnNftReq req, String classId, String owner, String nftId) {
        log.debug("BurnNftReq {}, classId {}, owner {}, nftId {}", req, classId, owner, nftId);
        log.debug("deleteNft start");
        // check params
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(DELETE_NFT, classId, owner, nftId);
        ForestResponse response = HttpClient.Delete(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("deleteNft end");
        return res;
    }

    @Override
    public PublicResponse batchCreateNft(BatchMintNftReq req, String classId) {
        log.debug("BatchMintNftReq {}, classId {}", req, classId);
        log.debug("batchCreateNft start");
        // check params
        if (StringUtils.isEmpty(req.getName())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "name"));
        }
        if (req.getRecipients() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "recipient"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(BATCH_CREATE_NFT, classId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("batchCreateNft end");
        return res;
    }

    @Override
    public PublicResponse batchTransferNft(BatchTransferNftReq req, String owner) {
        log.debug("BatchTransferNftReq {}, owner {}", req, owner);
        log.debug("batchTransferNft start");
        // check params
        if (req.getData() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "date"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(BATCH_TRANSFER_NFT, owner);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("batchTransferNft end");
        return res;

    }

    @Override
    public PublicResponse batchEditNft(BatchEditNftReq req, String owner) {
        log.debug("BatchEditNftReq {}, owner {}", req, owner);
        log.debug("batchEditNft start");
        // check params
        if (req.getNfts() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "nfts"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(BATCH_EDIT_NFT, owner);
        ForestResponse response = HttpClient.Patch(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("batchEditNft end");
        return res;
    }

    @Override
    public PublicResponse batchBurnNft(BatchBurnNftReq req, String owner) {
        log.debug("BatchBurnNftReq {}, owner {}", req, owner);
        log.debug("batchDeleteNft start");
        // check params
        if (req.getNfts() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "nfts"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(BATCH_DELETE_NFT, owner);
        ForestResponse response = HttpClient.Delete(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("batchDeleteNft end");
        return res;
    }

    @Override
    public QueryNftsRes queryNfts(QueryNftsReq req) {
        log.debug("QueryNftsReq {}", req);
        log.debug("queryNfts start");
        ForestResponse response = HttpClient.Get(QUERY_NFTS, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        QueryNftsRes res = JSONObject.parseObject(result, QueryNftsRes.class);
        
        log.debug("queryNfts end");
        return res;
    }

    @Override
    public QueryNftRes queryNft(String classId, String nftId) {
        log.debug("classId {}, nftId {}", classId, nftId);
        log.debug("queryNft start");
        String path = String.format(QUERY_NFT, classId,nftId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        
        QueryNftRes res = JSONObject.parseObject(result, QueryNftRes.class);
        
        log.debug("queryNft end");
        return res;
    }

    @Override
    public QueryNftHistoryRes queryNftHistory(String classId, String nftId) {
        log.debug("classId {}, nftId {}", classId, nftId);
        log.debug("queryNftHistory start");
        String path = String.format(QUERY_NFT_HISTORY, classId,nftId);
        ForestResponse response = HttpClient.Get(path, "");
        String result = response.readAsString();
        
        QueryNftHistoryRes res = JSONObject.parseObject(result, QueryNftHistoryRes.class);
        
        log.debug("queryNftHistory end");
        return res;
    }

}