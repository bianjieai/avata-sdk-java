package ai.bianjie.avatasdk.proxy.user;

import ai.bianjie.avatasdk.model.PublicResponse;
import ai.bianjie.avatasdk.model.user.*;

public interface UserProxy {

    /**
     * 创建用户
     *
     * @param req 创建用户请求实体
     * @return
     */
    CreateUserRes createUser(CreateUserReq req);

    /**
     * 更新用户
     *
     * @param req 更新用户请求实体
     * @return
     */
    PublicResponse updateUser(UpdateUserReq req);


    /**
     * 查询用户信息
     *
     * @param req 查询用户信息请求实体
     * @return
     */
    QueryUserRes queryUser(QueryUserReq req);
}
