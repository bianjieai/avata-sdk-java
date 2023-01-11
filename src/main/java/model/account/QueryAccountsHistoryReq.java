package model.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QueryAccountsHistoryReq {
    private String offset;
    private String limit;
    private String account;
    private String module;
    private String operation;
    private String txHash;
    private String startDate;
    private String endDate;
    private String sortBy;
}
