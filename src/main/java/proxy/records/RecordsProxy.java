package proxy.records;

import model.PublicResponse;
import model.records.CreateRecordReq;

public interface RecordsProxy {
    PublicResponse createRecord(CreateRecordReq req);
}
