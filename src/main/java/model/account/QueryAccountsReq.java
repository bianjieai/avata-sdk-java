package model.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QueryAccountsReq {
    private String offset;
    private String limit;
    private String account;
    private String name;
    private String operationId;
    private String startDate;
    private String endDate;
    private String sortBy;
}
