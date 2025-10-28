package ai.bianjie.avatasdk.proxy.user;

import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.user.*;

public interface UserProxy {

    /**
     * 创建钱包用户
     *
     * @param req 创建钱包用户请求实体
     * @return
     */
    CreateUserRes createUser(CreateUserReq req);

    /**
     * 更新钱包用户
     *
     * @param req 更新钱包用户请求实体
     * @return
     */
    PublicResponse updateUser(UpdateUserReq req);


    /**
     * 认证钱包用户
     *
     * @param req 认证钱包用户请求实体
     * @return
     */
    PublicResponse kycUser(KycUserReq req);

    /**
     * 查询钱包用户信息
     *
     * @param req 查询钱包用户信息请求实体
     * @return
     */
    QueryUserRes queryUser(QueryUserReq req);
}
