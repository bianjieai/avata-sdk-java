package ai.bianjie.avatasdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询链账户正确返回值
 */
@NoArgsConstructor
@Data
public class QueryAccountsRes {

    @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {

        @JSONField(name = "prev_page_key")
        private String prevPageKey;// 上一页数据的Key， Avata会根据该值进行上一页数据的查询

        @JSONField(name = "next_page_key")
        private String nextPageKey;// 下一页数据的Key， Avata会根据该值进行上一页数据的查询

        @JSONField(name = "limit")
        private Integer limit;// 每页记录数

        @JSONField(name = "total_count")
        private Integer totalCount;// 总记录数

        @JSONField(name = "accounts")
        private List<AccountsDTO> accounts;// 链账户列表

        @NoArgsConstructor
        @Data
        public static class AccountsDTO {

            @JSONField(name = "native_address")
            private String nativeAddress;// todo

            @JSONField(name = "hex_address")
            private String hexAddress;// todo

            @JSONField(name = "name")
            private String name;// 链账户名称

            @JSONField(name = "operation_id")
            private String operationId;// 操作 ID
        }
    }
}
