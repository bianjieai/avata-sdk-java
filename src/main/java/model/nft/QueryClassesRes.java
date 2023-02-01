package model.nft;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BaseResponse;

import java.util.List;

@NoArgsConstructor
@Data
public class QueryClassesRes extends BaseResponse {
    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JSONField(name = "offset")
        private Integer offset;
        @JSONField(name = "limit")
        private Integer limit;
        @JSONField(name = "total_count")
        private Integer totalCount;
        @JSONField(name = "classes")
        private List<ClassesDTO> classes;


        @NoArgsConstructor
        @Data
        public static class ClassesDTO {
            @JSONField(name = "id")
            private String id;
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "symbol")
            private String symbol;
            @JSONField(name = "nft_count")
            private Integer nftCount;
            @JSONField(name = "uri")
            private String uri;
            @JSONField(name = "owner")
            private String owner;
            @JSONField(name = "tx_hash")
            private String txHash;
            @JSONField(name = "timestamp")
            private String timestamp;


        }
    }
}
