package model.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BatchCreateAccountReq {

    private Integer count;
    private String operationId;
}
