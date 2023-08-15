package ai.bianjie.avatasdk.proxy.evm.contract.impl;

import ai.bianjie.avatasdk.config.ConfigInfo;
import ai.bianjie.avatasdk.exception.AvataException;
import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.evm.contract.ContractCallReq;
import ai.bianjie.avatasdk.model.evm.contract.QueryContractCallReq;
import ai.bianjie.avatasdk.model.evm.contract.QueryContractCallRes;
import ai.bianjie.avatasdk.proxy.evm.contract.ContractProxy;
import ai.bianjie.avatasdk.util.HttpClient;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContractClient implements ContractProxy {

    private static final String CONTRACT_CALL = "/v3/evm/contract/calls";// 调用合约接口
    private static final String QUERY_CONTRACT_CALL = "/v3/evm/contract/calls";// 查询合约接口
    private HttpClient httpClient;

    public ContractClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public PublicResponse contractCall(ContractCallReq req) {
        log.debug("ContractCallReq {}", req);
        log.debug("contractCall start");
        // check params
        if (StringUtils.isEmpty(req.getTo())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "to"));
        }
        if (StringUtils.isEmpty(req.getData())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "data"));
        }
        if (req.getGasLimit() == null) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "gas_limit"));
        }
        if (StringUtils.isEmpty(req.getOperationId())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "operation_id"));
        }
        if (StringUtils.isEmpty(req.getFrom())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "from"));
        }
        ForestResponse response = httpClient.post(CONTRACT_CALL, JSONObject.toJSONString(req));
        String result = response.readAsString();
        PublicResponse res = JSONObject.parseObject(result, PublicResponse.class);
        log.debug("contractCall end");
        return res;
    }

    @Override
    public QueryContractCallRes queryContractCall(QueryContractCallReq req) {
        log.debug("QueryContractCallReq {}", req);
        log.debug("queryContractCall start");
        // check params
        if (StringUtils.isEmpty(req.getTo())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "to"));
        }
        if (StringUtils.isEmpty(req.getData())) {
            throw AvataException.InvalidParamException(String.format(AvataException.PARAM_ERROR, "data"));
        }
        ForestResponse response = httpClient.get(QUERY_CONTRACT_CALL, JSONObject.toJSONString(req));
        String result = response.readAsString();
        QueryContractCallRes res = JSONObject.parseObject(result, QueryContractCallRes.class);
        log.debug("queryContractCall end");
        return res;
    }
}
