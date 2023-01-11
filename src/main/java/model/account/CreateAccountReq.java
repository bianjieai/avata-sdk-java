package model.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreateAccountReq {

    private String name;
    private String operationId;
}
