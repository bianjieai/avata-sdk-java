package proxy.mt;

import model.PublicResponse;
import model.mt.*;

public interface MtProxy {
    /**
     * 创建 MT 类别
     * @return
     */
    PublicResponse createMtClass(CreateMtClassReq req);

    /**
     * 查询 MT 类别
     * @return
     */
    QueryMtClassesRes queryMtClasses(QueryMtClassesReq req);

    /**
     * 查询 MT 类别详情
     * @return
     */
    QueryMtClassRes queryMtClass(String classId);

    /**
     * 转让 MT 类别
     * @return
     */
    PublicResponse transferMtClass(TransferMtClassReq req, String classId, String owner);

    /**
     * 发行 MT
     * @return
     */
    PublicResponse createMt(CreateMtReq req, String classId);

    /**
     * 增发 MT
     * @return
     */
    PublicResponse mintMt(MintMtReq req, String classId, String mtId);

    /**
     * 转让 MT
     * @return
     */
    PublicResponse transferMt(TransferMtReq req, String classId, String owner, String mtId);

    /**
     * 编辑 MT
     * @return
     */
    PublicResponse editMt(EditMtReq req, String classId, String owner, String mtId);

    /**
     * 销毁 MT
     * @return
     */
    PublicResponse deleteMt(DeleteMtReq req, String classId, String owner, String mtId);

    /**
     * 查询 MT
     * @return
     */
    QueryMtsRes queryMts(QueryMtsReq req);

    /**
     * 查询 MT 详情
     * @return
     */
    QueryMtRes queryMt(QueryMtReq req, String classId, String mtId);

    /**
     * 查询 MT 操作记录
     * @return
     */
    QueryMtHistoryRes queryMtHistory(QueryMtHistoryReq req, String classId, String mtId);

    /**
     * 查询 MT 余额
     * @return
     */
    QueryMtBalancesRes queryMtBalances(QueryMtBalancesReq req, String classId, String account);
}
