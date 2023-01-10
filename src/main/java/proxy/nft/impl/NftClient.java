package proxy.nft.impl;

import com.alibaba.fastjson.JSONObject;
import constant.ErrorMessage;
import exception.SdkException;
import model.PublicResponse;
import model.nft.*;
import okhttp3.Response;
import proxy.nft.NftProxy;
import util.HttpClient;
import util.Strings;

public class NftClient implements NftProxy {
    private static final String CREATE_CLASS = "/v1beta1/nft/classes";
    private static final String QUERY_CLASS = "/v1beta1/nft/classes";
    private static final String QUERY_CLASS_DETAIL = "/v1beta1/nft/classes/";
    private static final String TRANSFER_CLASS = "/v1beta1/nft/class-transfers/";
    private static final String CREATE_NFT = "/v1beta1/nft/nfts/";
    private static final String TRANSFER_NFT = "/v1beta1/nft/nft-transfers/";

    private static final String DELETE_NFT = "/v1beta1/nft/nfts/";

    @Override
    public PublicResponse createClass(CreateClassRequest createClassRequest) {
        HttpReq httpReq = new HttpReq();

        // todo 校验必填参数
        if (Strings.isEmpty(createClassRequest.getName())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }
        if (Strings.isEmpty(createClassRequest.getOwner())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }
        if (Strings.isEmpty(createClassRequest.getOperationId())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }

        // 请求body
        String result;
        try {
            Response res = httpReq.Post(CREATE_CLASS, JSONObject.toJSONString(createClassRequest));
            result = res.body().string();
        } catch (Exception e) {
            //todo err
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        return response;
    }

    @Override
    public QueryClassResponse queryClass(QueryClassRequest queryClassRequest) {
        // todo 优化httpreq获取
        HttpReq httpReq = new HttpReq();
        //如果要加查询条件
        StringBuffer sb = new StringBuffer();
        sb.append(QUERY_CLASS);
        sb.append(queryClassRequest.getName());
        String result;
        try {
            Response res = httpReq.Get(sb.toString(), "");
            result = res.body().string();
        } catch (Exception e) {
            // todo 定义错误类型
            throw new SdkException(ErrorMessage.UNKNOWN_ERROR);
        }
        QueryClassResponse response = JSONObject.parseObject(result, QueryClassResponse.class);
        return response;
    }

    @Override
    public QueryClassDetailResponse queryClassDetail(String classId) {
        // todo 优化httpreq获取
        HttpReq httpReq = new HttpReq();
        StringBuffer sb = new StringBuffer();
        sb.append(QUERY_CLASS_DETAIL);
        sb.append(classId);
        String result;
        try {
            Response res = httpReq.Get(sb.toString(), "");
            result = res.body().string();
        } catch (Exception e) {
            // todo 定义错误类型
            throw new SdkException(ErrorMessage.UNKNOWN_ERROR);
        }
        QueryClassDetailResponse res = JSONObject.parseObject(result, QueryClassDetailResponse.class);
        return res;
    }

    @Override
    public PublicResponse transferClass(TransferClassRequest transferClassRequest, String classId, String owner) {
        HttpReq httpReq = new HttpReq();

        // todo 校验必填参数
        if (Strings.isEmpty(transferClassRequest.getRecipient())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }
        if (Strings.isEmpty(transferClassRequest.getOperationId())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }

        // 请求body
        StringBuffer sb = new StringBuffer();
        sb.append(TRANSFER_CLASS);
        sb.append(classId);
        sb.append(owner);
        String result;
        try {
            Response res = httpReq.Post(sb.toString(), JSONObject.toJSONString(transferClassRequest));
            result = res.body().string();
        } catch (Exception e) {
            //todo err
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        return response;
    }

    @Override
    public PublicResponse createNft(CreateNftRequest createNftRequest, String classId) {
        HttpClient httpReq = new HttpClient();

        // todo 校验必填参数
        if (Strings.isEmpty(createNftRequest.getName())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }
        if (Strings.isEmpty(createNftRequest.getOperationId())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
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
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        return response;
    }

    @Override
    public  PublicResponse transferNft(TransferNftRequest transferNftRequest, String classId, String owner, String nftId){
        HttpReq httpReq = new HttpReq();

        // todo 校验必填参数
        if (Strings.isEmpty(transferNftRequest.getRecipient())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }
        if (Strings.isEmpty(transferNftRequest.getOperationId())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }

        // 请求body
        StringBuffer sb = new StringBuffer();
        sb.append(TRANSFER_NFT);
        sb.append(classId);
        sb.append(owner);
        sb.append(nftId);
        String result;
        try {
            Response res = httpReq.Post(sb.toString(), JSONObject.toJSONString(transferNftRequest));
            result = res.body().string();
        } catch (Exception e) {
            //todo err
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        return response;
    }

    @Override
    public PublicResponse deleteNft(DeleteNftRequest deleteNftRequest,String classId,String owner,String nftId){
        HttpReq httpReq = new HttpReq();

        // todo 校验必填参数
        if (Strings.isEmpty(deleteNftRequest.getOperationId())) {
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);//todo
        }

        // 请求body
        StringBuffer sb = new StringBuffer();
        sb.append(DELETE_NFT);
        sb.append(classId);
        sb.append(owner);
        sb.append(nftId);
        String result;
        try {
            Response res = httpReq.Post(sb.toString(), JSONObject.toJSONString(deleteNftRequest));
            result = res.body().string();
        } catch (Exception e) {
            //todo err
            throw new SdkException(ErrorMessage.INTERNAL_ERROR);
        }
        PublicResponse response = JSONObject.parseObject(result, PublicResponse.class);
        return response;
    }
}
