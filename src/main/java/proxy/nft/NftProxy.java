package proxy.nft;

import model.PublicResponse;
import model.nft.*;

public interface NftProxy {

    /**
     * 创建 NFT 类别
     * @param req 请求参数
     * @return
     */
    PublicResponse createClass(CreateClassReq req);

    /**
     * 查询 NFT 类别
     * @param req 请求参数
     * @return
     */
    QueryClassResp queryClass(QueryClassReq req);

    /**
     * 查询 NFT 类别详情
     * @param classId 路径参数
     * @return
     */
    QueryClassDetailResp queryClassDetail(String classId);

    /**
     * 转让 NFT 类别
     * @param req
     * @param classId
     * @param owner
     * @return
     */
    PublicResponse transferClass(TransferClassReq req, String classId, String owner);

    /**
     * 发行 NFT
     * @param req 请求参数
     * @return
     */
    PublicResponse createNft(CreateNftReq req, String classId);

    /**
     * 转让 NFT
     * @param req
     * @param classId
     * @param owner
     * @param nftId
     * @return
     */
    PublicResponse transferNft(TransferNftReq req, String classId, String owner, String nftId);

    /**
     * 编辑 NFT
     * @param req
     * @param classId
     * @param owner
     * @param nftId
     * @return
     */
    PublicResponse editNft(EditNftReq req, String classId, String owner, String nftId);

    /**
     * 销毁 NFT
     * @param req
     * @param classId
     * @param owner
     * @param nftId
     * @return
     */
    PublicResponse deleteNft(DeleteNftReq req, String classId, String owner, String nftId);

    /**
     * 批量发行 NFT
     * @param req
     * @param classId
     * @return
     */
    PublicResponse batchCreateNft(BatchCreateNftReq req, String classId);

    /**
     * 批量转让 NFT
     * @param req
     * @param owner
     * @return
     */
    PublicResponse batchTransferNft(BatchTransferNftReq req, String owner);

    /**
     * 批量编辑 NFT
     * @param req
     * @param owner
     * @return
     */
    PublicResponse batchEditNft(BatchEditNftReq req, String owner);

    /**
     * 批量销毁 NFT
     * @param req
     * @param owner
     * @return
     */
    PublicResponse batchDeleteNft(BatchDeleteNftReq req, String owner);

    /**
     * 查询 NFT
     * @param req
     * @return
     */
    QueryNftResp queryNft(QueryNftReq req);

    /**
     * 查询 NFT 详情
     * @param classId
     * @param nftId
     * @return
     */
    QueryNftDetailResp queryNftDetail(String classId, String nftId);

    /**
     * 查询 NFT 操作记录
     * @param classId
     * @param nftId
     * @return
     */
    QueryNftHistoryResp queryNftHistory(String classId, String nftId);
}
