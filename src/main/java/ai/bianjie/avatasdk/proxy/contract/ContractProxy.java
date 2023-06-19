package ai.bianjie.avatasdk.proxy.contract;

import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.contract.ContractCallReq;
import ai.bianjie.avatasdk.model.contract.QueryContractCallReq;
import ai.bianjie.avatasdk.model.contract.QueryContractCallRes;

public interface ContractProxy {
    /**
     * 调用合约
     *
     * @param req 调用合约请求体
     * @return
     */
    PublicResponse contractCall(ContractCallReq req);

    /**
     * 查询合约
     *
     * @param req 查询合约请求体
     * @return
     */
    QueryContractCallRes queryContractCall(QueryContractCallReq req);
}
