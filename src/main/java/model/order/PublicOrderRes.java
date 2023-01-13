package model.order;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;
import model.PublicResponse;

@NoArgsConstructor
@Data
public class PublicOrderRes extends BaseResponse {
    @JSONField(name = "data")
    private PublicResponse.DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "order_id")
        private String orderId;
    }
}
