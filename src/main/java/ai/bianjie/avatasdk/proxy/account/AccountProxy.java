package ai.bianjie.avatasdk.proxy.account;

import ai.bianjie.avatasdk.model.account.*;

public interface AccountProxy {

    /**
     * 创建链账户
     *
     * @param req 创建链账户请求实体
     * @return
     */
    CreateAccountRes createAccount(CreateAccountReq req);

    /**
     * 批量创建链账户
     *
     * @param req 批量创建链账户请求实体
     * @return
     */
    BatchCreateAccountRes batchCreateAccounts(BatchCreateAccountReq req);

    /**
     * 查询链账户
     *
     * @param req 查询链账户请求实体
     * @return
     */
    QueryAccountsRes queryAccounts(QueryAccountsReq req);

    /**
     * 原生项目 查询链账户操作记录
     *
     * @param req 查询链账户操作记录请求实体
     * @return
     */
    QueryNatAccountsHistoryRes queryNativeAccountsHistory(QueryAccountsHistoryReq req);

    /**
     * EVM项目 查询链账户操作记录
     *
     * @param req 查询链账户操作记录请求实体
     * @return
     */
    QueryEvmAccountsHistoryRes queryEvmAccountsHistory(QueryAccountsHistoryReq req);
}


