package ai.bianjie.avatasdk.proxy.ns;

import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.ns.*;

public interface NsProxy {

    /**
     * 注册域名
     *
     * @param req 注册域名请求实体
     * @return
     */
    PublicResponse registerDomain(RegisterDomainReq req);

    /**
     * 查询域名
     *
     * @param req 查询域名请求实体
     * @return
     */
    QueryDomainRes queryDomain(QueryDomainReq req);

    /**
     * 查询用户域名
     *
     * @param req 查询用户域名请求实体
     * @return
     */
    QueryOwnerDomainRes queryOwnerDomain(QueryOwnerDomainReq req, String owner);

    /**
     * 转让域名
     *
     * @param req 转让域名请求实体
     * @return
     */
    PublicResponse transferDomain(TransferDomainReq req, String owner, String name);
}
