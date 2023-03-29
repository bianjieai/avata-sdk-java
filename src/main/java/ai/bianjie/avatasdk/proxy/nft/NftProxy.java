package ai.bianjie.avatasdk.proxy.nft;

import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.nft.*;

public interface NftProxy {

    /**
     * 创建 NFT 类别
     *
     * @param req 创建 NFT 类别请求实体
     * @return
     */
    PublicResponse createClass(CreateNftClassReq req);

    /**
     * 查询 NFT 类别
     *
     * @param req 查询 NFT 类别请求实体
     * @return
     */
    QueryNftClassesRes queryClasses(QueryNftClassesReq req);

    /**
     * 查询 NFT 类别详情
     *
     * @param classId NFT 类别 ID
     * @return
     */
    QueryNftClassRes queryClass(String classId);

    /**
     * 转让 NFT 类别
     *
     * @param req     转让 NFT 类别请求实体
     * @param classId NFT 类别 ID
     * @param owner   NFT 类别权属者地址
     * @return
     */
    PublicResponse transferClass(TransferNftClassReq req, String classId, String owner);

    /**
     * 发行 NFT
     *
     * @param req     发行 NFT请求实体
     * @param classId NFT 类别 ID
     * @return
     */
    PublicResponse createNft(MintNftReq req, String classId);

    /**
     * 转让 NFT
     *
     * @param req     转让 NFT请求实体
     * @param classId NFT 类别 ID
     * @param owner   NFT 持有者地址
     * @param nftId   NFT ID
     * @return
     */
    PublicResponse transferNft(TransferNftReq req, String classId, String owner, String nftId);

    /**
     * 编辑 NFT
     *
     * @param req     编辑 NFT 请求实体
     * @param classId NFT 类别 ID
     * @param owner   NFT 持有者地址，也是 Tx 签名者地址
     * @param nftId   NFT ID
     * @return
     */
    PublicResponse editNft(EditNftReq req, String classId, String owner, String nftId);

    /**
     * 销毁 NFT
     *
     * @param req     销毁 NFT 请求实体
     * @param classId NFT 类别 ID
     * @param owner   NFT 持有者地址，也是 Tx 签名者地址
     * @param nftId   NFT ID
     * @return
     */
    PublicResponse burnNft(BurnNftReq req, String classId, String owner, String nftId);

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
     * @param nftId   NFT ID
     * @return
     */
    QueryNftRes queryNft(String classId, String nftId);

    /**
     * 查询 NFT 操作记录
     *
     * @param classId NFT 类别 ID
     * @param nftId   NFT ID
     * @param req     查询 NFT 操作记录请求实体
     * @return
     */
    QueryNftHistoryRes queryNftHistory(String classId, String nftId, QueryNftHistoryReq req);
}
