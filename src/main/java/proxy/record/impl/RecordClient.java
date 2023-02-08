package proxy.record.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import exception.AvataException;
import lombok.extern.slf4j.Slf4j;
import model.BaseResponse;
import model.PublicResponse;
import model.records.CreateRecordReq;
import proxy.record.RecordProxy;
import util.HttpClient;
import com.dtflys.forest.utils.StringUtils;

@Slf4j
public class RecordClient implements RecordProxy {
    private static final String CREATE_RECORD = "/v1beta1/record/records";

    @Override
    public PublicResponse createRecord(CreateRecordReq req) {
        log.debug("CreateRecordReq {}", req);
        log.info("createRecord start");
        // check params
        if (req.getType() == null) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "type"));
        }
        if (StringUtils.isEmpty(req.getName())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "name"));
        }
        if (StringUtils.isEmpty(req.getDescription())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "description"));
        }
        if (StringUtils.isEmpty(req.getHash())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "hash"));
        }
        if (req.getHashType() == null) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "hash_type"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.NewSDKException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        ForestResponse response = HttpClient.Post(CREATE_RECORD, JSONObject.toJSONString(req));
        String result = response.readAsString();
        
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        res.setHttp(new BaseResponse.Http(response.getStatusCode(), response.getReasonPhrase()));
        log.info("createRecord end");
        return res;
    }
}
