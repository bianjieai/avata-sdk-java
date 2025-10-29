package ai.bianjie.avatasdk.model.account;

import com.alibaba.fastjson2.annotation.JSONField;
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
            private String nativeAddress;// 原生地址格式

            @JSONField(name = "hex_address")
            private String hexAddress;// 以太坊地址格式

            @JSONField(name = "name")
            private String name;// 链账户名称

            @JSONField(name = "operation_id")
            private String operationId;// 操作 ID

            @JSONField(name = "read_only")
            private String readOnly;// 如果使用【钱包应用】对应的项目参数调用该查询链账户接口时，会返回该字段。该字段用于区分某一指定链账户地址是否属于当前项目参数所对应的钱包应用。
            //0: 由当前钱包创建，代表对某一指定地址拥有操作权限
            //1: 由其他钱包创建，代表对某一指定地址只有只读权限，没有操作权限
        }
    }
}
