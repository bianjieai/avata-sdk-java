package ai.bianjie.avatasdk.proxy.nft.impl;

import ai.bianjie.avatasdk.config.ConfigInfo;
import ai.bianjie.avatasdk.exception.AvataException;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.nft.*;
import ai.bianjie.avatasdk.proxy.nft.NftProxy;
import ai.bianjie.avatasdk.util.HttpClient;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NftClient implements NftProxy {
    private static final String CREATE_CLASS = "/v2/nft/classes";
    private static final String QUERY_CLASSES = "/v2/nft/classes";
    private static final String QUERY_CLASS = "/v2/nft/classes/%s";
    private static final String TRANSFER_CLASS = "/v2/nft/class-transfers/%s/%s";
    private static final String CREATE_NFT = "/v2/nft/nfts/%s";
    private static final String TRANSFER_NFT = "/v2/nft/nft-transfers/%s/%s/%s";
    private static final String EDIT_NFT = "/v2/nft/nfts/%s/%s/%s";
    private static final String DELETE_NFT = "/v2/nft/nfts/%s/%s/%s";
    private static final String BATCH_CREATE_NFT = "/v2/nft/batch/nfts/%s";
    private static final String BATCH_TRANSFER_NFT = "/v2/nft/batch/nft-transfers/%s";
    private static final String BATCH_EDIT_NFT = "/v2/nft/batch/nfts/%s";
    private static final String BATCH_DELETE_NFT = "/v2/nft/batch/nfts/%s";
    private static final String QUERY_NFTS = "/v2/nft/nfts";
    private static final String QUERY_NFT = "/v2/nft/nfts/%s/%s";
    private static final String QUERY_NFT_HISTORY = "/v2/nft/nfts/%s/%s/history";

    private ConfigInfo configInfo;

    public NftClient(ConfigInfo configInfo) {
        this.configInfo = configInfo;
    }


    @Override
    public PublicResponse createClass(CreateNftClassReq req) {
        log.debug("CreateMtClassReq {}", req);
        log.debug("createClass start");
        // check params
        if (StringUtils.isEmpty(req.getName())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "name"));
        }
        if (StringUtils.isEmpty(req.getSymbol())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "symbol"));
        }
        if (StringUtils.isEmpty(req.getOwner())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "owner"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        ForestResponse response = HttpClient.Post(CREATE_CLASS, JSONObject.toJSONString(req), configInfo);

        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("createClass end");
        return res;
    }

    @Override
    public QueryNftClassesRes queryClasses(QueryNftClassesReq req) {
        log.debug("QueryNftClassesReq {}", req);
        log.debug("queryClasses start");
        ForestResponse response = HttpClient.Get(QUERY_CLASSES, JSONObject.toJSONString(req), configInfo);
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
        ForestResponse response = HttpClient.Get(path, "", configInfo);
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
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req), configInfo);
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("transferClass end");
        return res;

    }

    @Override
    public PublicResponse createNft(MintNftReq req, String classId) {
        log.debug("MintNftReq {}, classId {}", req, classId);
        log.debug("createNft start");

        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        if (StringUtils.isEmpty(req.getUri())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "uri"));
        }
        if (StringUtils.isEmpty(req.getUriHash())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "urihash"));
        }
        if (StringUtils.isEmpty(req.getRecipient())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "recipient"));
        }
        String path = String.format(CREATE_NFT, classId);
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req), configInfo);
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
        ForestResponse response = HttpClient.Post(path, JSONObject.toJSONString(req), configInfo);
        String result = response.readAsString();

        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);

        log.debug("transferNft end");
        return res;
    }

    @Override
    public PublicResponse editNft(EditNftReq req, String classId, String owner, String nftId) {
        log.debug("EditNftReq {}, classId {}, owner {}, nftId {}", req, classId, owner, nftId);
        log.debug("editNft start");

        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        if (StringUtils.isEmpty(req.getUri())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "uri"));
        }
        String path = String.format(EDIT_NFT, classId, owner, nftId);
        ForestResponse response = HttpClient.Patch(path, JSONObject.toJSONString(req), configInfo);
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
        ForestResponse response = HttpClient.Delete(path, JSONObject.toJSONString(req), configInfo);
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("deleteNft end");
        return res;
    }

    @Override
    public QueryNftsRes queryNfts(QueryNftsReq req) {
        log.debug("QueryNftsReq {}", req);
        log.debug("queryNfts start");
        ForestResponse response = HttpClient.Get(QUERY_NFTS, JSONObject.toJSONString(req), configInfo);
        String result = response.readAsString();

        QueryNftsRes res = JSONObject.parseObject(result, QueryNftsRes.class);

        log.debug("queryNfts end");
        return res;
    }

    @Override
    public QueryNftRes queryNft(String classId, String nftId) {
        log.debug("classId {}, nftId {}", classId, nftId);
        log.debug("queryNft start");
        String path = String.format(QUERY_NFT, classId, nftId);
        ForestResponse response = HttpClient.Get(path, "", configInfo);
        String result = response.readAsString();

        QueryNftRes res = JSONObject.parseObject(result, QueryNftRes.class);

        log.debug("queryNft end");
        return res;
    }

    @Override
    public QueryNftHistoryRes queryNftHistory(String classId, String nftId, QueryNftHistoryReq req) {
        log.debug("classId {}, nftId {}", classId, nftId);
        log.debug("queryNftHistory start");
        String path = String.format(QUERY_NFT_HISTORY, classId, nftId);
        ForestResponse response = HttpClient.Get(path, "", configInfo);
        String result = response.readAsString();

        QueryNftHistoryRes res = JSONObject.parseObject(result, QueryNftHistoryRes.class);

        log.debug("queryNftHistory end");
        return res;
    }

}