package ai.bianjie.avatasdk.proxy.evm.ns;

import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.evm.ns.*;

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


    /**
     * 设置域名解析
     *
     * @param req   设置域名解析请求实体
     * @param owner 域名拥有者地址
     * @param name  域名名称
     * @return
     */
    PublicResponse ResolveDomain(ResolveDomainReq req, String owner, String name);


    /**
     * 查询域名解析
     *
     * @param name 域名名称
     * @param req  查询域名解析请求实体
     * @return
     */
    QueryDomainResolvesRes queryDomainResolves(String name, QueryDomainResolvesReq req);

    /**
     * 设置域名反向解析
     *
     * @param req   设置域名反向解析请求实体
     * @param owner 域名拥有者地址
     * @return
     */

    PublicResponse reverseResolveDomain(ReverseResolveDomainReq req, String owner);


    /**
     * 查询域名反向解析
     *
     * @param owner 域名拥有者地址
     */

    QueryReverseResolveDomainRes queryReverseResolveDomain(String owner);
}
