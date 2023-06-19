package ai.bianjie.avatasdk.proxy.records.impl;

import ai.bianjie.avatasdk.config.ConfigInfo;
import ai.bianjie.avatasdk.exception.AvataException;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.records.CreateRecordReq;
import ai.bianjie.avatasdk.proxy.records.RecordsProxy;
import ai.bianjie.avatasdk.util.HttpClient;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecordsClient implements RecordsProxy {

    private static final String CREATE_RECORD = "/v2/record/records";// 创建存证

    private ConfigInfo configInfo;

    public RecordsClient(ConfigInfo configInfo) {
        this.configInfo = configInfo;
    }

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
        ForestResponse response = HttpClient.Post(CREATE_RECORD, JSONObject.toJSONString(req), configInfo);
        PublicResponse res = JSONObject.parseObject(response.readAsString(), PublicResponse.class);
        log.debug("createRecord end");
        return res;
    }
}
