package proxy.nft;

import model.PublicResponse;
import model.nft.*;

public interface NftProxy {

    /**
     * 创建 NFT 类别
     *
     * @param req 创建 NFT 类别请求实体
     * @return
     */
    PublicResponse createClass(CreateClassReq req);

    /**
     * 查询 NFT 类别
     *
     * @param req 查询 NFT 类别请求实体
     * @return
     */
    QueryClassesRes queryClasses(QueryClassesReq req);

    /**
     * 查询 NFT 类别详情
     *
     * @param classId NFT 类别 ID
     * @return
     */
    QueryClassRes queryClass(String classId);

    /**
     * 转让 NFT 类别
     *
     * @param req     转让 NFT 类别请求实体
     * @param classId NFT 类别 ID
     * @param owner   NFT 类别权属者地址
     * @return
     */
    PublicResponse transferClass(TransferClassReq req, String classId, String owner);

    /**
     * 发行 NFT
     *
     * @param req     发行 NFT请求实体
     * @param classId NFT 类别 ID
     * @return
     */
    PublicResponse createNft(CreateNftReq req, String classId);

    /**
     * 转让 NFT
     *
     * @param req 转让 NFT请求实体
     * @param classId NFT 类别 ID
     * @param owner NFT 持有者地址
     * @param nftId NFT ID
     * @return
     */
    PublicResponse transferNft(TransferNftReq req, String classId, String owner, String nftId);

    /**
     * 编辑 NFT
     *
     * @param req 编辑 NFT 请求实体
     * @param classId NFT 类别 ID
     * @param owner NFT 持有者地址，也是 Tx 签名者地址
     * @param nftId NFT ID
     * @return
     */
    PublicResponse editNft(EditNftReq req, String classId, String owner, String nftId);

    /**
     * 销毁 NFT
     *
     * @param req 销毁 NFT 请求实体
     * @param classId NFT 类别 ID
     * @param owner NFT 持有者地址，也是 Tx 签名者地址
     * @param nftId NFT ID
     * @return
     */
    PublicResponse deleteNft(DeleteNftReq req, String classId, String owner, String nftId);

    /**
     * 批量发行 NFT
     *
     * @param req 批量发行 NFT 请求实体
     * @param classId NFT 类别 ID
     * @return
     */
    PublicResponse batchCreateNft(BatchCreateNftReq req, String classId);

    /**
     * 批量转让 NFT
     *
     * @param req 批量转让 NFT 请求实体
     * @param owner NFT 持有者地址
     * @return
     */
    PublicResponse batchTransferNft(BatchTransferNftReq req, String owner);

    /**
     * 批量编辑 NFT
     *
     * @param req 批量编辑 NFT请求实体
     * @param owner NFT 持有者地址，也是 Tx 签名者地址
     * @return
     */
    PublicResponse batchEditNft(BatchEditNftReq req, String owner);

    /**
     * 批量销毁 NFT
     *
     * @param req 批量销毁 NFT请求实体
     * @param owner NFT 持有者地址，也是 Tx 签名者地址
     * @return
     */
    PublicResponse batchDeleteNft(BatchDeleteNftReq req, String owner);

    /**
     * 查询 NFT
     *
     * @param req 查询 NFT请求实体
     * @return
     */
    QueryNftsRes queryNfts(QueryNftsReq req);

    /**
     * 查询 NFT 详情
     *
     * @param classId NFT 类别 ID
     * @param nftId NFT ID
     * @return
     */
    QueryNftRes queryNft(String classId, String nftId);

    /**
     * 查询 NFT 操作记录
     *
     * @param classId NFT 类别 ID
     * @param nftId NFT ID
     * @return
     */
    QueryNftHistoryRes queryNftHistory(String classId, String nftId);
}
