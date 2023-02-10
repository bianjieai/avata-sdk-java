package ai.bianjie.avatasdk.proxy.record.impl;

import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import ai.bianjie.avatasdk.exception.AvataException;
import lombok.extern.slf4j.Slf4j;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.records.CreateRecordReq;
import ai.bianjie.avatasdk.proxy.record.RecordProxy;
import ai.bianjie.avatasdk.util.HttpClient;
import com.dtflys.forest.utils.StringUtils;

@Slf4j
public class RecordClient implements RecordProxy {
    private static final String CREATE_RECORD = "/v1beta1/record/records";

    @Override
    public PublicResponse createRecord(CreateRecordReq req) {
        log.debug("CreateRecordReq {}", req);
        log.debug("createRecord start");
        // check params
        if (req.getType() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "type"));
        }
        if (StringUtils.isEmpty(req.getName())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "name"));
        }
        if (StringUtils.isEmpty(req.getDescription())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "description"));
        }
        if (StringUtils.isEmpty(req.getHash())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "hash"));
        }
        if (req.getHashType() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "hash_type"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        ForestResponse response = HttpClient.Post(CREATE_RECORD, JSONObject.toJSONString(req));
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("createRecord end");
        return res;
    }
}
