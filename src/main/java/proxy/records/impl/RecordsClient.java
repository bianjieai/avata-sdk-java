package proxy.records.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import constant.ErrorMessage;
import exception.SdkException;
import model.BaseResponse;
import model.ErrorResponse;
import model.PublicResponse;
import model.records.CreateRecordReq;
import proxy.records.RecordsProxy;
import util.HttpClient;
import util.Strings;

public class RecordsClient implements RecordsProxy {
    private static final String CREATE_RECORD = "/v1beta1/record/records";

    @Override
    public PublicResponse createRecord(CreateRecordReq req) {
        // check params
        if (req.getType() == null) {
            throw new SdkException(ErrorMessage.TYPE_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getName())) {
            throw new SdkException(ErrorMessage.NAME_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getDescription())) {
            throw new SdkException(ErrorMessage.DESCRIPTION_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getHash())) {
            throw new SdkException(ErrorMessage.HASH_ERROR, null, null);
        }
        if (req.getHashType() == null) {
            throw new SdkException(ErrorMessage.HASH_TYPE_ERROR, null, null);
        }
        if (Strings.isEmpty(req.getOperationId())) {
            throw new SdkException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        ForestResponse response = HttpClient.Post(CREATE_RECORD, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new SdkException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new SdkException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }
}
