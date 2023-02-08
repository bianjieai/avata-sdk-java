package proxy.record.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import constant.ErrorMessage;
import exception.AvataException;
import model.BaseResponse;
import model.ErrorResponse;
import model.PublicResponse;
import model.records.CreateRecordReq;
import proxy.record.RecordProxy;
import util.HttpClient;
import com.dtflys.forest.utils.StringUtils;

public class RecordClient implements RecordProxy {
    private static final String CREATE_RECORD = "/v1beta1/record/records";

    @Override
    public PublicResponse createRecord(CreateRecordReq req) {
        // check params
        if (req.getType() == null) {
            throw new AvataException(ErrorMessage.TYPE_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getName())) {
            throw new AvataException(ErrorMessage.NAME_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getDescription())) {
            throw new AvataException(ErrorMessage.DESCRIPTION_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getHash())) {
            throw new AvataException(ErrorMessage.HASH_ERROR, null, null);
        }
        if (req.getHashType() == null) {
            throw new AvataException(ErrorMessage.HASH_TYPE_ERROR, null, null);
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw new AvataException(ErrorMessage.OPERATION_ID_ERROR, null, null);
        }
        ForestResponse response = HttpClient.Post(CREATE_RECORD, JSONObject.toJSONString(req));
        String result = response.readAsString();
        if (response.getStatusCode() != 200) {
            ErrorResponse errorResponse = JSONObject.parseObject(result, ErrorResponse.class);
            throw new AvataException(ErrorMessage.AVATA_ERROR, errorResponse.getError(), new AvataException.Http(response.getStatusCode(), response.getReasonPhrase()));
        }
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        return res;
    }
}
