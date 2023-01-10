package proxy.nft;

import model.PublicResponse;
import model.nft.CreateNftRequest;

public interface NftProxy {
    /**
     * 创建一个NFT
     * @param createNftRequest 请求参数
     * @return
     */
    PublicResponse createNft(CreateNftRequest createNftRequest, String classId);
}
