package ai.bianjie.avatasdk.proxy.evm.nft.impl;

import ai.bianjie.avatasdk.exception.AvataException;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.evm.nft.*;
import ai.bianjie.avatasdk.proxy.evm.nft.NftProxy;
import ai.bianjie.avatasdk.util.HttpClient;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Nft implements NftProxy {
    private static final String CREATE_NFT_CLASS = "/v3/evm/nft/classes"; // 创建 NFT 类别
    private static final String QUERY_NFT_CLASSES = "/v3/evm/nft/classes";// 查询 NFT 类别
    private static final String QUERY_NFT_CLASS = "/v3/evm/nft/classes/%s";// 查询 NFT 类别详情
    private static final String TRANSFER_NFT_CLASS = "/v3/evm/nft/class-transfers/%s/%s";// 转让 NFT 类别
    private static final String MINT_NFT = "/v3/evm/nft/nfts/%s";// 发行 NFT
    private static final String TRANSFER_NFT = "/v3/evm/nft/nft-transfers/%s/%s/%s";// 转让 NFT
    private static final String EDIT_NFT = "/v3/evm/nft/nfts/%s/%s/%s";// 编辑 NFT
    private static final String DELETE_NFT = "/v3/evm/nft/nfts/%s/%s/%s";// 销毁 NFT
    private static final String QUERY_NFTS = "/v3/evm/nft/nfts";// 查询 NFT
    private static final String QUERY_NFT = "/v3/evm/nft/nfts/%s/%s";// 查询 NFT 详情
    private static final String QUERY_NFT_HISTORY = "/v3/evm/nft/nfts/%s/%s/history";// 查询 NFT 操作记录

    private HttpClient httpClient;

    public Nft(HttpClient httpClient) {
        this.httpClient = httpClient;
    }


    @Override
    public PublicResponse createNftClass(CreateNftClassReq req) {
        log.debug("CreateNftClassReq {}", req);
        log.debug("createNftClass start");
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
        ForestResponse response = httpClient.post(CREATE_NFT_CLASS, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("createNftClass end");
        return res;
    }

    @Override
    public QueryNftClassesRes queryNftClasses(QueryNftClassesReq req) {
        log.debug("QueryNftClassesReq {}", req);
        log.debug("queryNftClasses start");
        ForestResponse response = httpClient.get(QUERY_NFT_CLASSES, JSONObject.toJSONString(req));
        String result = response.readAsString();
        QueryNftClassesRes res = JSONObject.parseObject(result, QueryNftClassesRes.class);
        log.debug("queryNftClasses end");
        return res;
    }

    @Override
    public QueryNftClassRes queryNftClass(String classId) {
        log.debug("classId {}", classId);
        log.debug("queryNftClass start");
        String path = String.format(QUERY_NFT_CLASS, classId);
        ForestResponse response = httpClient.get(path, "");
        String result = response.readAsString();
        QueryNftClassRes res = JSONObject.parseObject(result, QueryNftClassRes.class);
        log.debug("queryNftClass end");
        return res;
    }

    @Override
    public PublicResponse transferNftClass(TransferNftClassReq req, String classId, String owner) {
        log.debug("TransferNftClassReq {}, classId {}, owner {}", req, classId, owner);
        log.debug("transferNftClass start");
        // check params
        if (StringUtils.isEmpty(req.getRecipient())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "recipient"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(TRANSFER_NFT_CLASS, classId, owner);
        ForestResponse response = httpClient.post(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("transferNftClass end");
        return res;

    }

    @Override
    public PublicResponse mintNft(MintNftReq req, String classId) {
        log.debug("MintNftReq {}, classId {}", req, classId);
        log.debug("mintNft start");
        // check params
        if (StringUtils.isEmpty(req.getUri())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "uri"));
        }
        if (StringUtils.isEmpty(req.getRecipient())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "recipient"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(MINT_NFT, classId);
        ForestResponse response = httpClient.post(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("mintNft end");
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
        ForestResponse response = httpClient.post(path, JSONObject.toJSONString(req));
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
        if (StringUtils.isEmpty(req.getUri())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "uri"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(EDIT_NFT, classId, owner, nftId);
        ForestResponse response = httpClient.patch(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("editNft end");
        return res;
    }

    @Override
    public PublicResponse burnNft(BurnNftReq req, String classId, String owner, String nftId) {
        log.debug("BurnNftReq {}, classId {}, owner {}, nftId {}", req, classId, owner, nftId);
        log.debug("burnNft start");
        // check params
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        String path = String.format(DELETE_NFT, classId, owner, nftId);
        ForestResponse response = httpClient.delete(path, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("burnNft end");
        return res;
    }


    @Override
    public QueryNftsRes queryNfts(QueryNftsReq req) {
        log.debug("QueryNftsReq {}", req);
        log.debug("queryNfts start");
        ForestResponse response = httpClient.get(QUERY_NFTS, JSONObject.toJSONString(req));
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
        ForestResponse response = httpClient.get(path, "");
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
        ForestResponse response = httpClient.get(path, JSONObject.toJSONString(req));
        String result = response.readAsString();
        QueryNftHistoryRes res = JSONObject.parseObject(result, QueryNftHistoryRes.class);
        log.debug("queryNftHistory end");
        return res;
    }
}