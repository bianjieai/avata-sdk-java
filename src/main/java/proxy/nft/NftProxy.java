package proxy.nft;

import model.PublicResponse;
import model.nft.*;

public interface NftProxy {

    /**
     * 创建 NFT 类别
     * @param createClassRequest 请求参数
     * @return
     */
    PublicResponse createClass(CreateClassRequest createClassRequest);

    /**
     * 查询 NFT 类别
     * @param queryClassRequest 请求参数
     * @return
     */
    QueryClassResponse queryClass(QueryClassRequest queryClassRequest);

    /**
     * 查询 NFT 类别详情
     * @param classId 路径参数
     * @return
     */
    QueryClassDetailResponse queryClassDetail(String classId);

    /**
     * 转让 NFT 类别
     * @param transferClassRequest
     * @param classId
     * @param owner
     * @return
     */
    PublicResponse transferClass(TransferClassRequest transferClassRequest, String classId, String owner);

    /**
     * 发行 NFT
     * @param createNftRequest 请求参数
     * @return
     */
    PublicResponse createNft(CreateNftRequest createNftRequest, String classId);

    /**
     * 转让 NFT
     * @param transferNftRequest
     * @param classId
     * @param owner
     * @param nftId
     * @return
     */
    PublicResponse transferNft(TransferNftRequest transferNftRequest, String classId, String owner, String nftId);

    /**
     * 销毁 NFT
     * @param deleteNftRequest
     * @param classId
     * @param owner
     * @param nftId
     * @return
     */
    PublicResponse deleteNft(DeleteNftRequest deleteNftRequest, String classId, String owner, String nftId);
}
