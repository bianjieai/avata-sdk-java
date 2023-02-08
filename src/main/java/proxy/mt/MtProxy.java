package proxy.mt;

import model.PublicResponse;
import model.mt.*;

public interface MtProxy {
    /**
     * 创建 MT 类别
     *
     * @param req 创建 MT 类别请求实体
     * @return
     */
    PublicResponse createMtClass(CreateMtClassReq req);

    /**
     * 查询 MT 类别
     *
     * @param req 查询 MT 类别请求实体
     * @return
     */
    QueryMtClassesRes queryMtClasses(QueryMtClassesReq req);

    /**
     * 查询 MT 类别详情
     *
     * @param classId MT 类别 ID
     * @return
     */
    QueryMtClassRes queryMtClass(String classId);

    /**
     * 转让 MT 类别
     *
     * @param req     转让 MT 类别请求实体
     * @param classId MT 类别 ID
     * @param owner   MT 类别权属者地址
     * @return
     */
    PublicResponse transferMtClass(TransferMtClassReq req, String classId, String owner);

    /**
     * 发行 MT
     *
     * @param req     发行 MT 请求实体
     * @param classId MT 类别 ID
     * @return
     */
    PublicResponse createMt(IssueMtReq req, String classId);

    /**
     * 增发 MT
     *
     * @param req     增发 MT 请求实体
     * @param classId MT 的类别 ID
     * @param mtId    MT 的 ID
     * @return
     */
    PublicResponse mintMt(MintMtReq req, String classId, String mtId);

    /**
     * 转让 MT
     *
     * @param req     转让 MT 请求实体
     * @param classId MT 类别 ID
     * @param owner   MT 持有者地址
     * @param mtId    MT ID
     * @return
     */
    PublicResponse transferMt(TransferMtReq req, String classId, String owner, String mtId);

    /**
     * 编辑 MT
     *
     * @param req     编辑 MT 请求实体
     * @param classId MT 类别 ID
     * @param owner   MT 类别权属者地址
     * @param mtId    MT ID
     * @return
     */
    PublicResponse editMt(EditMtReq req, String classId, String owner, String mtId);

    /**
     * 销毁 MT
     *
     * @param req     销毁 MT 请求实体
     * @param classId MT 类别 ID
     * @param owner   MT 持有者地址
     * @param mtId    MT ID
     * @return
     */
    PublicResponse deleteMt(BurnMtReq req, String classId, String owner, String mtId);

    /**
     * 查询 MT
     *
     * @param req 查询 MT 请求实体
     * @return
     */
    QueryMtsRes queryMts(QueryMtsReq req);

    /**
     * 查询 MT 详情
     *
     * @param classId MT 类别 ID
     * @param mtId    MT ID
     * @return
     */
    QueryMtRes queryMt(String classId, String mtId);

    /**
     * 查询 MT 操作记录
     *
     * @param req 查询 MT 操作记录请求实体
     * @param classId MT 类别 ID
     * @param mtId MT ID
     * @return
     */
    QueryMtHistoryRes queryMtHistory(QueryMtHistoryReq req, String classId, String mtId);

    /**
     * 查询 MT 余额
     *
     * @param req 查询 MT 余额请求实体
     * @param classId MT 类别ID
     * @param account 链账户地址
     * @return
     */
    QueryMtBalancesRes queryMtBalances(QueryMtBalancesReq req, String classId, String account);
}
