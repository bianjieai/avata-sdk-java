package proxy.record;

import model.PublicResponse;
import model.records.CreateRecordReq;

public interface RecordProxy {
    /**
     * 数字作品存证接口, 创建数字作品存证
     *
     * @param req 创建数字作品存证请求实体
     * @return
     */
    PublicResponse createRecord(CreateRecordReq req);
}
