package proxy.nft;

import model.nft.CreateNftRequest;
import model.nft.CreateNftResponse;

public interface NftProxy {
    /**
     * 创建一个NFT
     * @param createNftRequest 请求参数
     * @return
     */
    CreateNftResponse createNft(CreateNftRequest createNftRequest);
}
