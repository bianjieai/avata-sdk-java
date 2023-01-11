package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PublicResponse extends BaseResponse {

    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        private String operationId;
    }
}
