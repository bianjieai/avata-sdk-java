package proxy.nft.impl;

import com.alibaba.fastjson.JSONObject;
import constant.ErrorMessage;
import exception.SdkException;
import model.PublicResponse;
import model.nft.CreateNftRequest;
import okhttp3.Response;
import proxy.nft.NftProxy;
import util.HttpClient;
import util.Strings;

public class NftClient implements NftProxy {
    private static final String CREATE_NFT = "/v1beta1/nft/nfts/";

    @Override
    public PublicResponse createNft(CreateNftRequest createNftRequest, String classId) {
        HttpClient httpReq = new HttpClient();

        // todo 校验必填参数
        if (Strings.isEmpty(createNftRequest.getName())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);//todo
        }
        if (Strings.isEmpty(createNftRequest.getOperationId())){
            throw new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);//todo
        }

        // 请求body
        StringBuffer sb = new StringBuffer();
        sb.append(CREATE_NFT);
        sb.append(classId);
        String result;
        try {
            Response res = httpReq.Post(sb.toString(), JSONObject.toJSONString(createNftRequest));
            result = res.body().string();
        } catch (Exception e) {
            //todo err
            throw new SdkException(ErrorMessage.INTERNAL_ERROR, null, null);
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        return response;
    }
}
