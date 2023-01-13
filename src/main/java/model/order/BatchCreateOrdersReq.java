package model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class BatchCreateOrdersReq {

    @JSONField(name = "list")
    private List<ListDTO> list;
    @JSONField(name = "order_id")
    private String orderId;

    @NoArgsConstructor
    @Data
    public static class ListDTO {
        @JSONField(name = "account")
        private String account;
        @JSONField(name = "amount")
        private Integer amount;
    }
}
